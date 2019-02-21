<template>
    <div class="container" style="max-width:1000px">
        <Form :model="formItem" :label-width="80">
            <FormItem label="昵称" class="mt-3">
                <Input v-model="formItem.nickname" placeholder=""></Input>
            </FormItem>
            <FormItem label="性别">
                <RadioGroup v-model="formItem.gender">
                    <Radio label="male">男</Radio>
                    <Radio label="female">女</Radio>
                </RadioGroup>
            </FormItem>
            <FormItem label="手机号">
                <Input v-model="formItem.telephone" placeholder=""></Input>
            </FormItem>
            <FormItem label="详细地址">
                <Input v-model="formItem.area" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入详细地址"></Input>
            </FormItem>
            <div  class="text-center"><Button type="primary" class="mx-auto">保存</Button></div>
        </Form>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                formItem: {
                    
                }
            }
        },
    }
</script>

<style scoped>

</style>