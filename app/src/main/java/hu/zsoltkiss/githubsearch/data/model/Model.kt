package hu.zsoltkiss.githubsearch.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SearchRepositoryResult (
    val totalCount: Long,
    val incompleteResults: Boolean,
    val items: List<RepositoryItem>
)

data class RepositoryItem (
    val id: Long,
    val nodeID: String,
    val name: String,
    val fullName: String,
    val private: Boolean,
    val owner: Owner,

    @SerializedName("html_url")
    @Expose
    val htmlURL: String,

    val description: String? = null,
    val fork: Boolean,
    val url: String,
    val forksURL: String,
    val keysURL: String,
    val collaboratorsURL: String,
    val teamsURL: String,
    val hooksURL: String,
    val issueEventsURL: String,
    val eventsURL: String,
    val assigneesURL: String,
    val branchesURL: String,
    val tagsURL: String,
    val blobsURL: String,
    val gitTagsURL: String,
    val gitRefsURL: String,
    val treesURL: String,
    val statusesURL: String,
    val languagesURL: String,

    @SerializedName("stargazers_url")
    @Expose
    val stargazersURL: String,

    val contributorsURL: String,
    val subscribersURL: String,
    val subscriptionURL: String,
    val commitsURL: String,
    val gitCommitsURL: String,
    val commentsURL: String,
    val issueCommentURL: String,
    val contentsURL: String,
    val compareURL: String,
    val mergesURL: String,
    val archiveURL: String,
    val downloadsURL: String,
    val issuesURL: String,
    val pullsURL: String,
    val milestonesURL: String,
    val notificationsURL: String,
    val labelsURL: String,
    val releasesURL: String,
    val deploymentsURL: String,

    @SerializedName("created_at")
    @Expose
    val createdAt: String,

    @SerializedName("updated_at")
    @Expose
    val updatedAt: String,

    val pushedAt: String,
    val gitURL: String,
    val sshURL: String,
    val cloneURL: String,
    val svnURL: String,
    val homepage: Any? = null,
    val size: Long,

    @SerializedName("stargazers_count")
    @Expose
    val stargazersCount: Long,

    val watchersCount: Long,
    val language: String,
    val hasIssues: Boolean,
    val hasProjects: Boolean,
    val hasDownloads: Boolean,
    val hasWiki: Boolean,
    val hasPages: Boolean,
    val hasDiscussions: Boolean,

    @SerializedName("forks_count")
    @Expose
    val forksCount: Long,

    val mirrorURL: Any? = null,
    val archived: Boolean,
    val disabled: Boolean,
    val openIssuesCount: Long,
    val license: License? = null,
    val allowForking: Boolean,
    val isTemplate: Boolean,
    val webCommitSignoffRequired: Boolean,
    val topics: List<Any?>,
    val visibility: String,
    val forks: Long,
    val openIssues: Long,
    val watchers: Long,
    val defaultBranch: String,
    val score: Long
)

data class License (
    val key: String,
    val name: String,
    val spdxID: String,
    val url: String,
    val nodeID: String
)

data class Owner (
    val login: String,
    val id: Long,
    val nodeID: String,

    @SerializedName("avatar_url")
    @Expose
    val avatarURL: String,

    val gravatarID: String,
    val url: String,
    val htmlURL: String,
    val followersURL: String,
    val followingURL: String,
    val gistsURL: String,
    val starredURL: String,
    val subscriptionsURL: String,
    val organizationsURL: String,
    val reposURL: String,
    val eventsURL: String,
    val receivedEventsURL: String,
    val type: String,
    val userViewType: String,
    val siteAdmin: Boolean
)

data class RepositoryDetails(
    val repositoryId: Long,
    val repositoryName: String,
    val repositoryDescription: String?,
    val repositoryUrl: String,
    val ownerName: String,
    val avatarUrl: String,
    val profileUrl: String,
    val starCount: Long,
    val forkCount: Long,
    val createdAt: String,
    val updatedAt: String
): Serializable
