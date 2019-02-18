<template>
    <Row>
    <Col :xs="10" :sm="10" :md="6" :lg="6">
    <Menu :theme="theme" active-name="1-1" :open-names="['1']" accordion>
                <MenuItem name="0" disabled>
                <div><Icon type="md-people" />&nbsp;&nbsp;&nbsp;{{onlineCount}}</div>
                </MenuItem>
                <Submenu name="1">
                    <template slot="title">
                        <Icon type="md-log-in" />
                        用户注册
                    </template>
                    <MenuItem name="1-1" to="/adminmanager/userregister">
                        <Icon type="md-person" />
                        USER注册
                    </MenuItem>
                    <MenuItem name="1-2" to="/adminmanager/makerregister">
                        <Icon type="md-people" />
                        MAKER注册
                    </MenuItem>
                </Submenu>
                <Submenu name="2">
                    <template slot="title">
                        <Icon type="md-log-out" />
                        用户删除
                    </template>
                    <MenuItem name="2-1" to="/adminmanager/deleteuser">
                    <Icon type="md-trash" />
                    删除用户
                    </MenuItem>
                </Submenu>
                <Submenu name="3">
                    <template slot="title">
                        <Icon type="ios-keypad" />
                        用户密码修改
                    </template>
                        <MenuItem name="3-1" to="/adminmanager/resetpassword">
                        <Icon type="ios-keypad" />
                        密码修改
                        </MenuItem>
                </Submenu>
                <Submenu name="4">
                    <template slot="title">
                        <Icon type="ios-paper" />
                        用户信息查询及修改
                    </template>
                        <MenuItem name="3-2" to="/adminmanager/changeinfo">
                        <Icon type="md-cloud-upload" />
                        信息查询及修改
                        </MenuItem>
                </Submenu>
                <MenuItem name="4">
                <div @click="exit"><Icon type="md-exit" />&nbsp;&nbsp;&nbsp;退出界面</div>
                </MenuItem>
                </Menu>
        </Col>
    <Col :xs="14" :sm="14" :md="18" :lg="18">
    <keep-alive>
        <router-view></router-view>
    </keep-alive>   
    </Col>
    
    </Row>
</template>

<script>
    export default {
        data(){
            return{
                theme:'light',
                onlineCount:"Error"
            }
        },
        mounted(){
            this.getcount();
        },
        methods:{
            exit(){
                this.$Modal.confirm({
                    title: '退出登录:',
                    content: '是否要退出管理员界面',
                    onOk: () => {
                    localStorage.removeItem('admintoken');
                    localStorage.removeItem('admintokenTime');
                    this.$router.push({path: '/'});
                    this.$router.go(0)
                    }
                });
            },
            getcount(){
                this.axios.get("/api/admin/count")
                .then((response)=>{this.onlineCount=response.data})
                .catch((error)=>{console.log(error);});
            }
        }
    }
</script>

<style scoped>

</style>