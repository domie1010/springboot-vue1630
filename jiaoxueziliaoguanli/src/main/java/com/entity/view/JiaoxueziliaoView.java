package com.entity.view;

import com.entity.JiaoxueziliaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 教学资料
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaoxueziliao")
public class JiaoxueziliaoView extends JiaoxueziliaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 资料类型的值
		*/
		private String jiaoxueziliaoValue;
		/**
		* 是否分享的值
		*/
		private String fenxiangValue;



		//级联表 kecheng
			/**
			* 课程 的 老师
			*/
			private Integer kechengLaoshiId;
			/**
			* 院系
			*/
			private Integer yuanxiTypes;
				/**
				* 院系的值
				*/
				private String yuanxiValue;
			/**
			* 课程名称
			*/
			private String kechengName;
			/**
			* 课程类别
			*/
			private Integer kechengTypes;
				/**
				* 课程类别的值
				*/
				private String kechengValue;
			/**
			* 上课地点
			*/
			private String kechengAddress;
			/**
			* 学分
			*/
			private Integer xuefen;

		//级联表 laoshi
			/**
			* 老师姓名
			*/
			private String laoshiName;
			/**
			* 老师手机号
			*/
			private String laoshiPhone;
			/**
			* 老师身份证号
			*/
			private String laoshiIdNumber;
			/**
			* 老师头像
			*/
			private String laoshiPhoto;
			/**
			* 电子邮箱
			*/
			private String laoshiEmail;

	public JiaoxueziliaoView() {

	}

	public JiaoxueziliaoView(JiaoxueziliaoEntity jiaoxueziliaoEntity) {
		try {
			BeanUtils.copyProperties(this, jiaoxueziliaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 资料类型的值
			*/
			public String getJiaoxueziliaoValue() {
				return jiaoxueziliaoValue;
			}
			/**
			* 设置： 资料类型的值
			*/
			public void setJiaoxueziliaoValue(String jiaoxueziliaoValue) {
				this.jiaoxueziliaoValue = jiaoxueziliaoValue;
			}
			/**
			* 获取： 是否分享的值
			*/
			public String getFenxiangValue() {
				return fenxiangValue;
			}
			/**
			* 设置： 是否分享的值
			*/
			public void setFenxiangValue(String fenxiangValue) {
				this.fenxiangValue = fenxiangValue;
			}














				//级联表的get和set kecheng
					/**
					* 获取：课程 的 老师
					*/
					public Integer getKechengLaoshiId() {
						return kechengLaoshiId;
					}
					/**
					* 设置：课程 的 老师
					*/
					public void setKechengLaoshiId(Integer kechengLaoshiId) {
						this.kechengLaoshiId = kechengLaoshiId;
					}

					/**
					* 获取： 院系
					*/
					public Integer getYuanxiTypes() {
						return yuanxiTypes;
					}
					/**
					* 设置： 院系
					*/
					public void setYuanxiTypes(Integer yuanxiTypes) {
						this.yuanxiTypes = yuanxiTypes;
					}


						/**
						* 获取： 院系的值
						*/
						public String getYuanxiValue() {
							return yuanxiValue;
						}
						/**
						* 设置： 院系的值
						*/
						public void setYuanxiValue(String yuanxiValue) {
							this.yuanxiValue = yuanxiValue;
						}
					/**
					* 获取： 课程名称
					*/
					public String getKechengName() {
						return kechengName;
					}
					/**
					* 设置： 课程名称
					*/
					public void setKechengName(String kechengName) {
						this.kechengName = kechengName;
					}
					/**
					* 获取： 课程类别
					*/
					public Integer getKechengTypes() {
						return kechengTypes;
					}
					/**
					* 设置： 课程类别
					*/
					public void setKechengTypes(Integer kechengTypes) {
						this.kechengTypes = kechengTypes;
					}


						/**
						* 获取： 课程类别的值
						*/
						public String getKechengValue() {
							return kechengValue;
						}
						/**
						* 设置： 课程类别的值
						*/
						public void setKechengValue(String kechengValue) {
							this.kechengValue = kechengValue;
						}
					/**
					* 获取： 上课地点
					*/
					public String getKechengAddress() {
						return kechengAddress;
					}
					/**
					* 设置： 上课地点
					*/
					public void setKechengAddress(String kechengAddress) {
						this.kechengAddress = kechengAddress;
					}
					/**
					* 获取： 学分
					*/
					public Integer getXuefen() {
						return xuefen;
					}
					/**
					* 设置： 学分
					*/
					public void setXuefen(Integer xuefen) {
						this.xuefen = xuefen;
					}


				//级联表的get和set laoshi
					/**
					* 获取： 老师姓名
					*/
					public String getLaoshiName() {
						return laoshiName;
					}
					/**
					* 设置： 老师姓名
					*/
					public void setLaoshiName(String laoshiName) {
						this.laoshiName = laoshiName;
					}
					/**
					* 获取： 老师手机号
					*/
					public String getLaoshiPhone() {
						return laoshiPhone;
					}
					/**
					* 设置： 老师手机号
					*/
					public void setLaoshiPhone(String laoshiPhone) {
						this.laoshiPhone = laoshiPhone;
					}
					/**
					* 获取： 老师身份证号
					*/
					public String getLaoshiIdNumber() {
						return laoshiIdNumber;
					}
					/**
					* 设置： 老师身份证号
					*/
					public void setLaoshiIdNumber(String laoshiIdNumber) {
						this.laoshiIdNumber = laoshiIdNumber;
					}
					/**
					* 获取： 老师头像
					*/
					public String getLaoshiPhoto() {
						return laoshiPhoto;
					}
					/**
					* 设置： 老师头像
					*/
					public void setLaoshiPhoto(String laoshiPhoto) {
						this.laoshiPhoto = laoshiPhoto;
					}
					/**
					* 获取： 电子邮箱
					*/
					public String getLaoshiEmail() {
						return laoshiEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setLaoshiEmail(String laoshiEmail) {
						this.laoshiEmail = laoshiEmail;
					}







}
