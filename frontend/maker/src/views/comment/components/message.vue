<template>
    <div>
    <textarea class="message" rows="10" cols="80" style="resize: none" placeholder="此处最多输入200字"></textarea>
    </div>
</template>

<script>
    export default {
        name: "message"
    }
</script>

<style scoped>
.message{
    border:3px solid #dddddd;
    margin-top: 30px;
    box-shadow: 0px 0px 1px 1px #dddddd;
    border-radius: 5px;
}
</style>