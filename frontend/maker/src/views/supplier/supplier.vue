<template>
    <div class="layout">
        <Layout>
            <Sider ref="side1" hide-trigger collapsible :collapsed-width="78" v-model="isCollapsed">
                <Menu theme="dark" width="auto" :class="menuitemClasses" active-name="1-1">
                    <Submenu name="1">
                        <template slot="title">
                            <Icon type="ios-navigate"></Icon>
                            <span>商品管理</span>
                        </template>
                        <MenuItem name="1-1"><router-link to='/supplier'><Icon type="ios-stats" style="margin-bottom:3px;margin-right:5px" /><span v-if="!isCollapsed">所有商品</span></router-link></MenuItem>
                        <MenuItem name="1-2"><router-link to='/supplier/addproduct'><Icon type="ios-add-circle-outline" style="margin-bottom:3px;margin-right:5px" /><span v-if="!isCollapsed">上架商品</span></router-link></MenuItem>
                        <MenuItem name="1-3"><router-link to='/supplier/updateproduct'><Icon type="ios-build-outline" style="margin-bottom:3px;margin-right:5px" /><span v-if="!isCollapsed">修改商品</span></router-link></MenuItem>
                    </Submenu>

                    <!-- <MenuItem name="1-2">
                        <Icon type="ios-search" /></Icon>
                        <span>订单查询</span>
                    </MenuItem> -->
                </Menu>
            </Sider>
            <Layout>
                <Header :style="{padding: 0}" class="layout-header-bar">
                    <Icon @click.native="collapsedSider" :class="rotateIcon" :style="{margin: '0 20px'}" type="md-menu" size="24"></Icon>
                </Header>
                <Content :style="{margin: '20px', background: '#fff', minHeight: '260px'}">
                    <keep-alive>
                        <router-view></router-view>
                    </keep-alive>
                </Content>
            </Layout>
        </Layout>
    </div>
</template>

<script>
    export default {
        data () {
            return {
                isCollapsed: false,
                buttonProps: {
                    type: 'default',
                    size: 'small'
                }
            }
        },
        computed: {
            rotateIcon () {
                return [
                    'menu-icon',
                    this.isCollapsed ? 'rotate-icon' : ''
                ];
            },
            menuitemClasses () {
                return [
                    'menu-item',
                    this.isCollapsed ? 'collapsed-menu' : ''
                ]
            }
        },
        methods: {
            collapsedSider () {
                this.$refs.side1.toggleCollapse();
            }
        }

    }
</script>

<style scoped>
.layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
}
.layout-header-bar{
    background: #fff;
    box-shadow: 0 1px 1px rgba(0,0,0,.1);
}
.layout-logo-left{
    width: 90%;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    margin: 15px auto;
}
.menu-icon{
    transition: all .3s;
}
.rotate-icon{
    transform: rotate(-90deg);
}
.menu-item span{
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
}
.menu-item i{
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
}
.collapsed-menu span{
    width: 0px;
    transition: width .2s ease;
}
.collapsed-menu i{
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
}
a{
    color: #c3c5cb;
}
a:hover{
    color: #fff;
}
</style>