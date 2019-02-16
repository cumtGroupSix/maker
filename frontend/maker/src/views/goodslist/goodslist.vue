<template>
<div id='root'>
	<Layout>
            <Sider breakpoint="md" ref="side1" hide-trigger collapsible :collapsed-width="78" v-model="isCollapsed" style="background:#ffffff">
                <Menu active-name="1-2" theme="light" width="auto" :class="menuitemClasses">
                    <MenuItem name="1-1">
                        <Icon type="ios-keypad"></Icon>
                        <span>全部分类</span>
                    </MenuItem>
                    <MenuItem name="1-2">
                        <Icon></Icon>
                        <span>小吃零食</span>
                    </MenuItem>
                    <MenuItem name="1-3">
                        <Icon></Icon>
                        <span>电子配件</span>
                    </MenuItem>
                    <MenuItem name="1-4">
                        <Icon></Icon>
                        <span>生活用品</span>
                    </MenuItem>
                    <MenuItem name="1-5">
                        <Icon></Icon>
                        <span>阅读书籍</span>
                    </MenuItem>
                </Menu>
            </Sider>
            <Layout>
                <Header :style="{padding: 0}" class="layout-header-bar">
                    <Icon @click.native="collapsedSider" :class="rotateIcon" :style="{margin: '0 20px'}" type="md-menu" size="24"></Icon>
                    <span style='font-size: 22px;'><b>商品选择列表</b></span>
                </Header>
                <Content :style="{margin: '20px', background: '#fff', minHeight: '260px'}">
                 <Table border  :columns="columns" :data="showList" style="margin:10px"></Table>
                 <br>
                 <div style="margin-bottom:30px">
                 <Page :total="total" :page-size="pageSize" @on-change="changepage" show-elevator show-total style="float:left;margin-left:10px;"/>
                 <Button style='float:right;margin-right:20px' size="large" type="default">确认选择</Button>
             	 </div>	
                 <br>
                </Content>
            </Layout>
        </Layout>
</div>
</template>

<script>
    export default {
    	 data () {
            return {
                pageSize:10,
                showList:[],
            	isCollapsed: false,
                columns: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        type: 'index',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '商品名称',
                        width: 260,
                        key: 'name'
                    },
                    {
                        title: '商品图片',
                        key: 'img'
                    },
                    {
                        title: '商品价格',
                        width:100,
                        key: 'price'
                    },
                    {
                        title: '商品库存',
                        width:100,
                        key: 'number'
                    },
                    {
                        title: '商品属性信息',
                        width: 300,
                        key: 'infos'
                    },
                ],
                data: [
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 18,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 24,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 26,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    },
                    {
                        name: '猫咪杯子情侣动物水杯',
                        price: 30,
                        infos: '颜色分类：红、黄、蓝；产地：徐州；容量：500ml；材质：陶瓷；风格：彩绘；',
                        img: '暂无图片供展示',
                        number: 18
                    }
                ]
            }
        },
        mounted (){
        this.setShowList();
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
            },
            total(){
                return this.data.length;
            }
        },
        methods: {
            setShowList(){
               this.showList=this.data.slice(0,this.pageSize); 
            },
            collapsedSider () {
                this.$refs.side1.toggleCollapse();
            },
            changepage(index){
                var start = (index-1)*this.pageSize;
                var end = index*this.pageSize;
                this.showList=this.data.slice(start,end);
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
</style>