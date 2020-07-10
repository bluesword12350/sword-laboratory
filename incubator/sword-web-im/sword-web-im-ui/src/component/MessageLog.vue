<template>
    <a-list
        class="comment-list"
        item-layout="horizontal"
        :data-source="messageLogList"
    >
        <a-list-item slot="renderItem" slot-scope="item, index">
            <a-comment :author="item.originAddress?item.originAddress:'me'">
                <p slot="content">
                    {{ item.text }}
                </p>
            </a-comment>
            <a-tooltip>
                <span>{{ item.targetAddress }}</span>
            </a-tooltip>
        </a-list-item>
    </a-list>
</template>

<script>
    import {messageLogList} from "../database/log"

    export default {
        name: "MessageLog",
        data(){
            return {
                messageLogList:messageLogList
            }
        }
    }
</script>

<style scoped>
</style>