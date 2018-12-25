<template>
    <div>
        <Row type="flex" align="top" class="code-row-bg mt-3" :gutter="16">
            <Col>
                <Avatar icon="ios-person" size="large" />
                <span class="mx-1">依劲方华旗舰店</span>
            </Col>
            <Col>
                <img src="@/assets/img/list-1.jpg" alt="" class="productImg">
            </Col>
            <Col>
                <p>猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子</p>
                <div class="price">￥20.00</div>
            </Col>
            <Col>
                <Rate disabled allow-half v-model="valueDisabled" />
            </Col>
            <Divider />
        </Row>
        <Row type="flex" align="top" class="code-row-bg mt-3" :gutter="16">
            <Col>
                <Avatar icon="ios-person" size="large" />
                <span class="mx-1">依劲方华旗舰店</span>
            </Col>
            <Col>
                <img src="@/assets/img/list-1.jpg" alt="" class="productImg">
            </Col>
            <Col>
                <p>猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子</p>
                <div class="price">￥20.00</div>
            </Col>
            <Col>
                <Rate disabled allow-half v-model="valueDisabled" />
            </Col>
            <Divider />
        </Row>
        <Row type="flex" align="top" class="code-row-bg mt-3" :gutter="16">
            <Col>
                <Avatar icon="ios-person" size="large" />
                <span class="mx-1">依劲方华旗舰店</span>
            </Col>
            <Col>
                <img src="@/assets/img/list-1.jpg" alt="" class="productImg">
            </Col>
            <Col>
                <p>猫咪杯子情侣动物水杯可爱创意陶瓷马克杯咖啡生日礼物带杯盖勺子</p>
                <div class="price">￥20.00</div>
            </Col>
            <Col>
                <Rate disabled allow-half v-model="valueDisabled" />
            </Col>
            <Divider />
        </Row>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                valueDisabled: 3.5
            }
        },
    }
</script>

<style scoped>
.productImg{
    width: 100px;
    height: 100px;
}
.price{
    color: red;
    margin-top: 20px;
}
</style>