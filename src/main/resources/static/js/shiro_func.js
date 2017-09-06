// 注册一个全局组件 shiro
 Vue.component('shiro', {
     template : '<div v-if="hasPermission()"><slot></slot></div>',
     props: {
         ispermission: {
             type: String,
             required:true
         }
     },
    data() {
        return {
            permission: []
        }
    },
    mounted(){
        this.loadPermission();
    },
    methods:{
        loadPermission(){   // 加载权限
            let vue = this;
            $.ajax({
                type: 'POST',
                url: '/getRolePermission',
                data: null,
                success: function (data) {
                    const obj = eval(data);
                    if (obj.code==="200"){
                        vue.permission=obj;
                    }
                }
            });
        },
        hasPermission:function () {
            if (this.permission.data!==undefined){
                return this.permission.data.indexOf(this.ispermission) > -1;
            }
            return false;
        }
    }
});