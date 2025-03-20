
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 教学资料
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaoxueziliao")
public class JiaoxueziliaoController {
    private static final Logger logger = LoggerFactory.getLogger(JiaoxueziliaoController.class);

    @Autowired
    private JiaoxueziliaoService jiaoxueziliaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private KechengService kechengService;
    @Autowired
    private LaoshiService laoshiService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiaoxueziliaoService.queryPage(params);

        //字典表数据转换
        List<JiaoxueziliaoView> list =(List<JiaoxueziliaoView>)page.getList();
        for(JiaoxueziliaoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaoxueziliaoEntity jiaoxueziliao = jiaoxueziliaoService.selectById(id);
        if(jiaoxueziliao !=null){
            //entity转view
            JiaoxueziliaoView view = new JiaoxueziliaoView();
            BeanUtils.copyProperties( jiaoxueziliao , view );//把实体数据重构到view中

                //级联表
                KechengEntity kecheng = kechengService.selectById(jiaoxueziliao.getKechengId());
                if(kecheng != null){
                    BeanUtils.copyProperties( kecheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setKechengId(kecheng.getId());
                    view.setKechengLaoshiId(kecheng.getLaoshiId());
                }
                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(jiaoxueziliao.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoxueziliaoEntity jiaoxueziliao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaoxueziliao:{}",this.getClass().getName(),jiaoxueziliao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            jiaoxueziliao.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiaoxueziliaoEntity> queryWrapper = new EntityWrapper<JiaoxueziliaoEntity>()
            .eq("laoshi_id", jiaoxueziliao.getLaoshiId())
            .eq("kecheng_id", jiaoxueziliao.getKechengId())
            .eq("jiaoxueziliao_name", jiaoxueziliao.getJiaoxueziliaoName())
            .eq("jiaoxueziliao_types", jiaoxueziliao.getJiaoxueziliaoTypes())
            .eq("banben", jiaoxueziliao.getBanben())
            .eq("fenxiang_types", jiaoxueziliao.getFenxiangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoxueziliaoEntity jiaoxueziliaoEntity = jiaoxueziliaoService.selectOne(queryWrapper);
        if(jiaoxueziliaoEntity==null){
            jiaoxueziliao.setInsertTime(new Date());
            jiaoxueziliao.setCreateTime(new Date());
            jiaoxueziliaoService.insert(jiaoxueziliao);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoxueziliaoEntity jiaoxueziliao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaoxueziliao:{}",this.getClass().getName(),jiaoxueziliao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            jiaoxueziliao.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JiaoxueziliaoEntity> queryWrapper = new EntityWrapper<JiaoxueziliaoEntity>()
            .notIn("id",jiaoxueziliao.getId())
            .andNew()
            .eq("laoshi_id", jiaoxueziliao.getLaoshiId())
            .eq("kecheng_id", jiaoxueziliao.getKechengId())
            .eq("jiaoxueziliao_name", jiaoxueziliao.getJiaoxueziliaoName())
            .eq("jiaoxueziliao_types", jiaoxueziliao.getJiaoxueziliaoTypes())
            .eq("banben", jiaoxueziliao.getBanben())
            .eq("fenxiang_types", jiaoxueziliao.getFenxiangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoxueziliaoEntity jiaoxueziliaoEntity = jiaoxueziliaoService.selectOne(queryWrapper);
        if("".equals(jiaoxueziliao.getJiaoxueziliaoFile()) || "null".equals(jiaoxueziliao.getJiaoxueziliaoFile())){
                jiaoxueziliao.setJiaoxueziliaoFile(null);
        }
        if(jiaoxueziliaoEntity==null){
            jiaoxueziliaoService.updateById(jiaoxueziliao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiaoxueziliaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<JiaoxueziliaoEntity> jiaoxueziliaoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiaoxueziliaoEntity jiaoxueziliaoEntity = new JiaoxueziliaoEntity();
//                            jiaoxueziliaoEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            jiaoxueziliaoEntity.setKechengId(Integer.valueOf(data.get(0)));   //课程 要改的
//                            jiaoxueziliaoEntity.setJiaoxueziliaoName(data.get(0));                    //教学资料名称 要改的
//                            jiaoxueziliaoEntity.setJiaoxueziliaoTypes(Integer.valueOf(data.get(0)));   //资料类型 要改的
//                            jiaoxueziliaoEntity.setJiaoxueziliaoFile(data.get(0));                    //资料文件 要改的
//                            jiaoxueziliaoEntity.setJiaoxueziliaoContent("");//照片
//                            jiaoxueziliaoEntity.setBanben(data.get(0));                    //版本 要改的
//                            jiaoxueziliaoEntity.setFenxiangTypes(Integer.valueOf(data.get(0)));   //是否分享 要改的
//                            jiaoxueziliaoEntity.setInsertTime(date);//时间
//                            jiaoxueziliaoEntity.setCreateTime(date);//时间
                            jiaoxueziliaoList.add(jiaoxueziliaoEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiaoxueziliaoService.insertBatch(jiaoxueziliaoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
