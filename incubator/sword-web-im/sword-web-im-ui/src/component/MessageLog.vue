<template>
    <a-list
        class="comment-list"
        item-layout="horizontal"
        :data-source="messageLogList"
    >
        <a-list-item slot="renderItem" slot-scope="item, index">
            <a-comment :author="item.origin">
                <p slot="content">
                    {{ item.text }}
                </p>
            </a-comment>
            <a-tooltip>
                <span>{{ item.target}}</span>
            </a-tooltip>
        </a-list-item>
    </a-list>
</template>

<script>
    import {messageManager} from "../database/messageManager"

    export default {
        name: "MessageLog",
        data(){
            return {
                messageLogList:messageManager.messageLog.getAll()
            }
        }
    }
</script>

<style scoped>
</style>