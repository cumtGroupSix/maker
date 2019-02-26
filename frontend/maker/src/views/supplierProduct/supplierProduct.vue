<template>
    <div>
        <Tree :data="data"></Tree>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                data: [
                    {
                        title: '',
                        expand: true,
                        children: [

                        ]
                    }
                ],
                mounted() {
                    this.axios.get('/api/category/all')
                },
            }
        },
    }
</script>

<style scoped>

</style>