package com.carrefour.kmpcodemagic.network.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CodeMagicResponse(
    @SerialName("applications") val applications: List<DTOApplication>? = null,
    @SerialName("builds") val builds: List<DTOBuild>? = null,
)

@Serializable
data class DTOApplication(
    @SerialName("_id") val id: String? = null,
    @SerialName("appName") val appName: String? = null,
)

@Serializable
data class DTOBuild(
    @SerialName("_id") val id: String? = null,
    @SerialName("index") val index: Int? = null,
    @SerialName("appId") val appId: String? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("version") val version: String? = null,
    @SerialName("branch") val branch: String? = null,
    @SerialName("startedAt") val startedAt: String? = null,
    @SerialName("startedBy") val startedBy: String? = null,
    @SerialName("createdAt") val createdAt: String? = null,
    @SerialName("finishedAt") val finishedAt: String? = null,
    @SerialName("workflowId") val workflowId: String? = null,
    @SerialName("fileWorkflowId") val fileWorkflowId: String? = null,
    @SerialName("instanceType") val instanceType: String? = null,
    @SerialName("commit") val commit: DTOCommit? = null,
    @SerialName("dynamicConfig") val dynamicConfig: Map<String, String>? = null,
    @SerialName("artefacts") val artefacts: List<DTOArtefact>? = null,
    @SerialName("buildActions") val buildActions: List<DTOBuildAction>? = null,
    @SerialName("message") val message: String? = null,
    @SerialName("screenshots") val screenshots: String? = null,
    @SerialName("pullRequest") val pullRequest: String? = null,
    @SerialName("tag") val tag: String? = null,
    @SerialName("scheduledBuildId") val scheduledBuildId: String? = null,
    @SerialName("appStoreConnectTasks") val appStoreConnectTasks: List<String>? = null,
    @SerialName("labels") val labels: List<String>? = null
)

@Serializable
data class DTOCommit(
    @SerialName("authorAvatarUrl") val authorAvatarUrl: String? = null,
    @SerialName("authorEmail") val authorEmail: String? = null,
    @SerialName("authorName") val authorName: String? = null,
    @SerialName("branch") val branch: String? = null,
    @SerialName("tag") val tag: String? = null,
    @SerialName("commitMessage") val commitMessage: String? = null,
    @SerialName("hash") val hash: String? = null,
    @SerialName("url") val url: String? = null
)

@Serializable
data class DTOBuildAction(
    @SerialName("_id") val id: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("logUrl") val logUrl: String? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("startedAt") val startedAt: String? = null,
    @SerialName("finishedAt") val finishedAt: String? = null,
    @SerialName("results") val results: List<String>? = null,
)

@Serializable
data class DTOArtefact(
    @SerialName("md5") val md5: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("packageName") val packageName: String? = null,
    @SerialName("size") val size: Int? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("versionName") val versionName: String? = null
)