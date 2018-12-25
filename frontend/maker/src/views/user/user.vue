<template>
    <Row>
        <Col :md={span:18,offset:3} :lg={span:18,offset:3}>
            <Row>
                <Col>
                    <Menu mode="horizontal" :theme="theme1" active-name="1">
                        <MenuItem name="1" to="/user/browse">
                            <Icon type="ios-paper" />
                            浏览记录
                        </MenuItem>
                    
                        <MenuItem name="2" to="/user/evaluate">
                            <Icon type="ios-people" />
                            评价记录
                        </MenuItem>
                        
                        <Submenu name="3">
                            <template slot="title">
                            <Icon type="ios-basket-outline" />
                            我的收藏
                            </template>
                            <MenuItem name="3-1" to="/user/myProduct">我收藏的商品</MenuItem>
                            <MenuItem name="3-2" to="/user/myStore">我收藏的店铺</MenuItem>
                        </Submenu>
                    </Menu>
                </Col>
            </Row>
            <Row>
                <keep-alive>
                    <router-view></router-view>
                </keep-alive>
            </Row>
        </Col>
    </Row>
</template>

<script>
    export default {
        data() {
            return {
                active: '1'
            }
        },
        mounted() {
            this.$nextTick(()=>{
                this.active = this.$route.path.slice(1)
                this.$refs.active.updateActiveName()
            })
        }
    }
</script>

<style scoped>

</style>