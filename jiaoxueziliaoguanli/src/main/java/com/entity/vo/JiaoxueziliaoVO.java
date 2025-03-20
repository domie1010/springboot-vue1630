package com.entity.vo;

import com.entity.JiaoxueziliaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教学资料
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaoxueziliao")
public class JiaoxueziliaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 课程
     */

    @TableField(value = "kecheng_id")
    private Integer kechengId;


    /**
     * 教学资料名称
     */

    @TableField(value = "jiaoxueziliao_name")
    private String jiaoxueziliaoName;


    /**
     * 资料类型
     */

    @TableField(value = "jiaoxueziliao_types")
    private Integer jiaoxueziliaoTypes;


    /**
     * 资料文件
     */

    @TableField(value = "jiaoxueziliao_file")
    private String jiaoxueziliaoFile;


    /**
     * 资料详情
     */

    @TableField(value = "jiaoxueziliao_content")
    private String jiaoxueziliaoContent;


    /**
     * 版本
     */

    @TableField(value = "banben")
    private String banben;


    /**
     * 是否分享
     */

    @TableField(value = "fenxiang_types")
    private Integer fenxiangTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：课程
	 */
    public Integer getKechengId() {
        return kechengId;
    }


    /**
	 * 获取：课程
	 */

    public void setKechengId(Integer kechengId) {
        this.kechengId = kechengId;
    }
    /**
	 * 设置：教学资料名称
	 */
    public String getJiaoxueziliaoName() {
        return jiaoxueziliaoName;
    }


    /**
	 * 获取：教学资料名称
	 */

    public void setJiaoxueziliaoName(String jiaoxueziliaoName) {
        this.jiaoxueziliaoName = jiaoxueziliaoName;
    }
    /**
	 * 设置：资料类型
	 */
    public Integer getJiaoxueziliaoTypes() {
        return jiaoxueziliaoTypes;
    }


    /**
	 * 获取：资料类型
	 */

    public void setJiaoxueziliaoTypes(Integer jiaoxueziliaoTypes) {
        this.jiaoxueziliaoTypes = jiaoxueziliaoTypes;
    }
    /**
	 * 设置：资料文件
	 */
    public String getJiaoxueziliaoFile() {
        return jiaoxueziliaoFile;
    }


    /**
	 * 获取：资料文件
	 */

    public void setJiaoxueziliaoFile(String jiaoxueziliaoFile) {
        this.jiaoxueziliaoFile = jiaoxueziliaoFile;
    }
    /**
	 * 设置：资料详情
	 */
    public String getJiaoxueziliaoContent() {
        return jiaoxueziliaoContent;
    }


    /**
	 * 获取：资料详情
	 */

    public void setJiaoxueziliaoContent(String jiaoxueziliaoContent) {
        this.jiaoxueziliaoContent = jiaoxueziliaoContent;
    }
    /**
	 * 设置：版本
	 */
    public String getBanben() {
        return banben;
    }


    /**
	 * 获取：版本
	 */

    public void setBanben(String banben) {
        this.banben = banben;
    }
    /**
	 * 设置：是否分享
	 */
    public Integer getFenxiangTypes() {
        return fenxiangTypes;
    }


    /**
	 * 获取：是否分享
	 */

    public void setFenxiangTypes(Integer fenxiangTypes) {
        this.fenxiangTypes = fenxiangTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
