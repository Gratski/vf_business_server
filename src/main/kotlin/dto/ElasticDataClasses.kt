package dto

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class ElasticStatus @JsonCreator constructor (
        @JsonProperty("name") val name : String,
        @JsonProperty("cluster_name") val cluster_name : String,
        @JsonProperty("cluster_uuid") val cluster_uuid : String,
        @JsonProperty("version") val version : Version,
        @JsonProperty("tagline") val tagline : String
)
data class Version @JsonCreator constructor (
        @JsonProperty("number") val number : String,
        @JsonProperty("build_flavor") val build_flavor : String,
        @JsonProperty("build_type") val build_type : String,
        @JsonProperty("build_hash") val build_hash : String,
        @JsonProperty("build_date") val build_date : String,
        @JsonProperty("build_snapshot") val build_snapshot : Boolean,
        @JsonProperty("lucene_version") val lucene_version : String,
        @JsonProperty("minimum_wire_compatibility_version") val minimum_wire_compatibility_version : String,
        @JsonProperty("minimum_index_compatibility_version") val minimum_index_compatibility_version : String
)