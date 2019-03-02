<style scoped>
    .expand-row{
        margin-bottom: 16px;
    }
</style>
<template>
    <div>
        <Row class="expand-row">
            <Col span="8">
                <span class="expand-key">邮箱: </span>
                <span class="expand-value">{{ row.email }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">收货地址: </span>
                <span class="expand-value">{{ row.address }}</span>
            </Col>
            <Col span="8">
                <span class="expand-key">学校名称: </span>
                <span class="expand-value">{{ row.school }}</span>
            </Col>
        </Row>
        <Row>
            <Col span="8">
                <span class="expand-key">注册时间: </span>
                <span class="expand-value">{{ row.registrationTime}}</span>
            </Col>
        </Row>
    </div>
</template>
<script>
    export default {
        props: {
            row: Object
        }
    };
</script>