<template>
    <div>
        <Table :columns="columns" :data="row.products">
            <template slot-scope="{ row, index }" slot="image">
                <img :src="row.imgUrl" alt="" style="height:100px">
            </template>
        </Table>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                columns: [
                    {
                        title: '产品名称',
                        key: 'productName'
                    },
                    {
                        title: '图片展示',
                        slot: 'image'
                    },
                    {
                        title: '价格',
                        key: 'price'
                    },
                    {
                        title: '库存',
                        key: 'stock'
                    },
                ]
            }
        },
        props: {
            row: Object
        }
    }
</script>

<style scoped>

</style>