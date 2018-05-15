package com.yipl.labelstep.util

class Utils {
    companion object {
        fun getUniqueId(userId: Long, entityId: Long): String {
            val id = System.currentTimeMillis().toString() + "-" + userId + "-" + entityId
            return id
        }
    }

}