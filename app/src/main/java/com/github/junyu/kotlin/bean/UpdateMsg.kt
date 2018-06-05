package com.github.junyu.kotlin.bean

import android.databinding.ObservableField
/**
 *
 * @author ShaoJunyu
 * @since 2018/6/5 17:33
 *
 */
data class UpdateMsg(
      val versionCode: ObservableField<Int> = ObservableField(),
      val versionName: ObservableField<String> = ObservableField()
)