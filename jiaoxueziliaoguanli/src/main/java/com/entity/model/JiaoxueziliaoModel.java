package com.entity.model;

import com.entity.JiaoxueziliaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教学资料
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoxueziliaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 课程
     */
    private Integer kechengId;


    /**
     * 教学资料名称
     */
    private String jiaoxueziliaoName;


    /**
     * 资料类型
     */
    private Integer jiaoxueziliaoTypes;


    /**
     * 资料文件
     */
    private String jiaoxueziliaoFile;


    /**
     * 资料详情
     */
    private String jiaoxueziliaoContent;


    /**
     * 版本
     */
    private String banben;


    /**
     * 是否分享
     */
    private Integer fenxiangTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：课程
	 */
    public Integer getKechengId() {
        return kechengId;
    }


    /**
	 * 设置：课程
	 */
    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 获取：教学资料名称
	 */
    public String getJiaoxueziliaoName() {
        return jiaoxueziliaoName;
    }


    /**
	 * 设置：教学资料名称
	 */
    public void setJiaoxueziliaoName(String jiaoxueziliaoName) {
        this.jiaoxueziliaoName = jiaoxueziliaoName;
    }
    /**
	 * 获取：资料类型
	 */
    public Integer getJiaoxueziliaoTypes() {
        return jiaoxueziliaoTypes;
    }


    /**
	 * 设置：资料类型
	 */
    public void setJiaoxueziliaoTypes(Integer jiaoxueziliaoTypes) {
        this.jiaoxueziliaoTypes = jiaoxueziliaoTypes;
    }
    /**
	 * 获取：资料文件
	 */
    public String getJiaoxueziliaoFile() {
        return jiaoxueziliaoFile;
    }


    /**
	 * 设置：资料文件
	 */
    public void setJiaoxueziliaoFile(String jiaoxueziliaoFile) {
        this.jiaoxueziliaoFile = jiaoxueziliaoFile;
    }
    /**
	 * 获取：资料详情
	 */
    public String getJiaoxueziliaoContent() {
        return jiaoxueziliaoContent;
    }


    /**
	 * 设置：资料详情
	 */
    public void setJiaoxueziliaoContent(String jiaoxueziliaoContent) {
        this.jiaoxueziliaoContent = jiaoxueziliaoContent;
    }
    /**
	 * 获取：版本
	 */
    public String getBanben() {
        return banben;
    }


    /**
	 * 设置：版本
	 */
    public void setBanben(String banben) {
        this.banben = banben;
    }
    /**
	 * 获取：是否分享
	 */
    public Integer getFenxiangTypes() {
        return fenxiangTypes;
    }


    /**
	 * 设置：是否分享
	 */
    public void setFenxiangTypes(Integer fenxiangTypes) {
        this.fenxiangTypes = fenxiangTypes;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
