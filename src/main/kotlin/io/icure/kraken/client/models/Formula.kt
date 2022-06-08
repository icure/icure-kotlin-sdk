/**
 * iCure Data Stack API Documentation
 *
 * The iCure Data Stack Application API is the native interface to iCure.
 *
 * The version of the OpenAPI document: v2
 * 
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */
package io.icure.kraken.client.models


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude


/**
 * 
 *
 * @param `value` 
 * @param lifecycle 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Formula (

    @field:JsonProperty("value")
    val `value`: kotlin.String? = null,

    @field:JsonProperty("lifecycle")
    val lifecycle: Formula.Lifecycle? = null

) {

    /**
     * 
     *
     * Values: onCreate,onLoad,onChange,onSave,onDestroy,onLoadPropertiesEditor
     */
    enum class Lifecycle(val value: kotlin.String) {
        @JsonProperty(value = "OnCreate") onCreate("OnCreate"),
        @JsonProperty(value = "OnLoad") onLoad("OnLoad"),
        @JsonProperty(value = "OnChange") onChange("OnChange"),
        @JsonProperty(value = "OnSave") onSave("OnSave"),
        @JsonProperty(value = "OnDestroy") onDestroy("OnDestroy"),
        @JsonProperty(value = "OnLoadPropertiesEditor") onLoadPropertiesEditor("OnLoadPropertiesEditor");
    }
}

