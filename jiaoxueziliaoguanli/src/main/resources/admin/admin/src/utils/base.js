const base = {
    get() {
        return {
            url : "http://localhost:8080/jiaoxueziliaoguanli/",
            name: "jiaoxueziliaoguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/jiaoxueziliaoguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "教学资料管理系统"
        } 
    }
}
export default base
