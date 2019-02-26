<template>
    <div>
        add
    </div>
</template>

<script>
    export default {
        data() {
            return {
                data:{
                    categoryId: 0,
                    productName: "string",
                    products: [
                        {
                        description: "string",
                        imageUrl: "string",
                        price: 0,
                        stock: 0,
                        specifications: [
                            {
                            "specificationName": "string",
                            "specificationValue": "string"
                            }
                        ]
                        }
                    ]
                }
            }
        },
    }
</script>

<style scoped>

</style>