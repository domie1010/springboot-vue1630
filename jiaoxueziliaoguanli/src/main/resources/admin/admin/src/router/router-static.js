import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import banji from '@/views/modules/banji/list'
    import dictionary from '@/views/modules/dictionary/list'
    import jiaoxueziliao from '@/views/modules/jiaoxueziliao/list'
    import kecheng from '@/views/modules/kecheng/list'
    import laoshi from '@/views/modules/laoshi/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import dictionaryFenxiang from '@/views/modules/dictionaryFenxiang/list'
    import dictionaryJiaoxueziliao from '@/views/modules/dictionaryJiaoxueziliao/list'
    import dictionaryKecheng from '@/views/modules/dictionaryKecheng/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryYuanxi from '@/views/modules/dictionaryYuanxi/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryFenxiang',
        name: '是否分享',
        component: dictionaryFenxiang
    }
    ,{
        path: '/dictionaryJiaoxueziliao',
        name: '资料类型',
        component: dictionaryJiaoxueziliao
    }
    ,{
        path: '/dictionaryKecheng',
        name: '课程类别',
        component: dictionaryKecheng
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryYuanxi',
        name: '院系',
        component: dictionaryYuanxi
    }


    ,{
        path: '/banji',
        name: '班级',
        component: banji
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/jiaoxueziliao',
        name: '教学资料',
        component: jiaoxueziliao
      }
    ,{
        path: '/kecheng',
        name: '课程',
        component: kecheng
      }
    ,{
        path: '/laoshi',
        name: '老师',
        component: laoshi
      }
    ,{
        path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
