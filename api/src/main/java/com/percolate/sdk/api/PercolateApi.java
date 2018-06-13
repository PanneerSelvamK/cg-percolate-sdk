package com.percolate.sdk.api;

import com.percolate.sdk.api.config.PercolateServer;
import com.percolate.sdk.api.request.activity.ActivityRequest;
import com.percolate.sdk.api.request.approvals.pools.ApprovalPoolsRequest;
import com.percolate.sdk.api.request.approvals.workflow.ApprovalWorkflowRequest;
import com.percolate.sdk.api.request.approvals.workflow.history.ApprovalWorkflowHistoryRequest;
import com.percolate.sdk.api.request.assets.AssetsRequest;
import com.percolate.sdk.api.request.auth.AuthRequest;
import com.percolate.sdk.api.request.authorization.UserRolesRequest;
import com.percolate.sdk.api.request.autocomplete.AutocompleteRequest;
import com.percolate.sdk.api.request.campaign.CampaignsRequest;
import com.percolate.sdk.api.request.campaignsection.CampaignSectionsRequest;
import com.percolate.sdk.api.request.channel.ChannelRequest;
import com.percolate.sdk.api.request.comment.CommentRequest;
import com.percolate.sdk.api.request.config.ConfigRequest;
import com.percolate.sdk.api.request.features.FeaturesRequest;
import com.percolate.sdk.api.request.folders.FoldersRequest;
import com.percolate.sdk.api.request.followers.FollowersRequest;
import com.percolate.sdk.api.request.interaction.InteractionRequest;
import com.percolate.sdk.api.request.license.LicenseRequest;
import com.percolate.sdk.api.request.license.settings.LicenseSettingsRequest;
import com.percolate.sdk.api.request.license.users.LicenseUsersRequest;
import com.percolate.sdk.api.request.licensechannel.LicenseChannelRequest;
import com.percolate.sdk.api.request.links.LinksRequest;
import com.percolate.sdk.api.request.media.MediaRequest;
import com.percolate.sdk.api.request.media.release.MediaReleaseRequest;
import com.percolate.sdk.api.request.metadata.MetadataRequest;
import com.percolate.sdk.api.request.monitoring.facebook.FacebookMonitoringRequest;
import com.percolate.sdk.api.request.monitoring.flagging.FlaggingRequest;
import com.percolate.sdk.api.request.monitoring.instagram.InstagramMonitoringRequest;
import com.percolate.sdk.api.request.monitoring.twitter.TwitterMonitoringRequest;
import com.percolate.sdk.api.request.platform.PlatformsRequest;
import com.percolate.sdk.api.request.post.PostRequest;
import com.percolate.sdk.api.request.post.plug.PostPlugRequest;
import com.percolate.sdk.api.request.post_attachment.PostAttachmentRequest;
import com.percolate.sdk.api.request.postset.PostSetRequest;
import com.percolate.sdk.api.request.preference.PreferenceRequest;
import com.percolate.sdk.api.request.preview.PreviewRequest;
import com.percolate.sdk.api.request.previewformat.PreviewFormatRequest;
import com.percolate.sdk.api.request.push.PushTokenRequest;
import com.percolate.sdk.api.request.release.ReleaseFormRequest;
import com.percolate.sdk.api.request.responses.CannedResponsesRequest;
import com.percolate.sdk.api.request.roles.RolesRequest;
import com.percolate.sdk.api.request.schema.SchemasRequest;
import com.percolate.sdk.api.request.shares.SharesRequest;
import com.percolate.sdk.api.request.streams.StreamsRequest;
import com.percolate.sdk.api.request.task.TasksRequest;
import com.percolate.sdk.api.request.tenant.TenantRequest;
import com.percolate.sdk.api.request.terms.TermsRequest;
import com.percolate.sdk.api.request.tokens.TokensRequest;
import com.percolate.sdk.api.request.topics.TopicsRequest;
import com.percolate.sdk.api.request.translate.TranslateRequest;
import com.percolate.sdk.api.request.upload.UploadRequest;
import com.percolate.sdk.api.request.users.UsersRequest;
import com.percolate.sdk.api.request.variants.VariantsRequest;
import com.percolate.sdk.api.request.vendor.facebook.FacebookVendorRequest;
import com.percolate.sdk.api.request.vendor.instagram.InstagramVendorRequest;
import com.percolate.sdk.api.request.vendor.twitter.TwitterVendorRequest;
import com.percolate.sdk.api.utils.ProjectVersion;
import com.percolate.sdk.api.utils.RetrofitApiFactory;
import com.percolate.sdk.api.utils.RetrofitLogic;

import org.jetbrains.annotations.Nullable;

/**
 * Percolate API.
 */
public class PercolateApi {

    /**
     * Java API SDK Version Number.
     */
    public static final String VERSION_NUMBER = ProjectVersion.VERSION;

    /**
     * User API key.
     */
    private String apiKey;

    /**
     * OAuth2 Token key.
     */
    private String oAuthTokenKey;

    /**
     * Selected server config.
     */
    private PercolateServer selectedServer;

    /**
     * UserAgent prefix.
     */
    private String userAgentPrefix;

    /**
     * Default server config that will be used if nothing else is provided.
     */
    public static final PercolateServer PROD = new PercolateServer("https", "percolate.com");

    /**
     * Create percolate API instance that accesses {@code percolate.com} endpoint.
     */
    public PercolateApi() {
        this(null, null);
    }

    /**
     * Create percolate API instance that accesses the given {@link PercolateServer} endpoint.
     */
    public PercolateApi(@Nullable PercolateServer selectedServer) {
        this(null, selectedServer);
    }

    /**
     * Create percolate API instance that accesses {@code percolate.com} endpoint.
     *
     * @param apiKey API key.
     */
    public PercolateApi(@Nullable String apiKey) {
        this(apiKey, null);
    }

    /**
     * Create percolate API instance that accesses the given {@link PercolateServer} endpoint.
     *
     * @param apiKey         API key.
     * @param selectedServer Server config.
     */
    public PercolateApi(@Nullable String apiKey, @Nullable PercolateServer selectedServer) {
        this.apiKey = apiKey;
        if (selectedServer != null) {
            this.selectedServer = selectedServer;
        } else {
            this.selectedServer = PROD;
        }
    }

    /**
     * Create percolate API instance that accesses the given {@link PercolateServer} endpoint.
     *
     * @param apiKey          API key.
     * @param selectedServer  Server config.
     * @param userAgentPrefix userAgent prefix.
     */
    public PercolateApi(@Nullable String apiKey, @Nullable PercolateServer selectedServer, @Nullable String userAgentPrefix) {
        this.apiKey = apiKey;
        this.userAgentPrefix = userAgentPrefix;
        if (selectedServer != null) {
            this.selectedServer = selectedServer;
        } else {
            this.selectedServer = PROD;
        }
    }

    /**
     * @return User API key.
     */
    public String getApiKey() {
        return apiKey;
    }

    /**
     * Set API Key.
     *
     * @param apiKey API Key.
     */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * @return OAuth2 Token key.
     */
    public String getOAuthTokenKey() {
        return oAuthTokenKey;
    }

    /**
     * Set OAuth2 Token key.
     *
     * @param oAuthTokenKey OAuth2 Token key.
     */
    public void setOAuthTokenKey(String oAuthTokenKey) {
        this.oAuthTokenKey = oAuthTokenKey;
    }

    /**
     * @return Selected server.
     */
    public PercolateServer getSelectedServer() {
        return selectedServer;
    }

    public void setSelectedServer(PercolateServer selectedServer) {
        this.selectedServer = selectedServer;
        RetrofitLogic.reset();
        RetrofitApiFactory.reset();
    }

    /**
     * @return userAgent prefix String.
     */
    public String getUserAgentPrefix() {
        return userAgentPrefix;
    }

    public void setUserAgentPrefix(String userAgentPrefix) {
        this.userAgentPrefix = userAgentPrefix;
        RetrofitLogic.reset();
        RetrofitApiFactory.reset();
    }

    /**
     * @return {@link AssetsRequest} instance.
     */
    public AssetsRequest assets() {
        return new AssetsRequest(this);
    }

    /**
     * @return {@link AuthRequest} instance.
     */
    public AuthRequest auth() {
        return new AuthRequest(this);
    }

    /**
     * @return {@link AutocompleteRequest} instance.
     */
    public AutocompleteRequest autocomplete() {
        return new AutocompleteRequest(this);
    }

    /**
     * @return {@link TermsRequest} instance.
     */
    @SuppressWarnings("unused")
    public TermsRequest terms() {
        return new TermsRequest(this);
    }

    /**
     * @return {@link ApprovalPoolsRequest} instance.
     */
    @SuppressWarnings("unused")
    public ApprovalPoolsRequest approvalPools() {
        return new ApprovalPoolsRequest(this);
    }

    /**
     * @return {@link ApprovalWorkflowRequest} instance.
     */
    @SuppressWarnings("unused")
    public ApprovalWorkflowRequest approvalWorkflow() {
        return new ApprovalWorkflowRequest(this);
    }

    /**
     * @return {@link ApprovalWorkflowHistoryRequest} instance.
     */
    @SuppressWarnings("unused")
    public ApprovalWorkflowHistoryRequest approvalWorkflowHistory() {
        return new ApprovalWorkflowHistoryRequest(this);
    }

    /**
     * @return {@link ActivityRequest} instance.
     */
    @SuppressWarnings("unused")
    public ActivityRequest activity() {
        return new ActivityRequest(this);
    }

    /**
     * @return {@link UserRolesRequest} instance.
     */
    @SuppressWarnings("unused")
    public UserRolesRequest userRoles() {
        return new UserRolesRequest(this);
    }

    /**
     * @return {@link CampaignsRequest} instance.
     */
    @SuppressWarnings("unused")
    public CampaignsRequest campaigns() {
        return new CampaignsRequest(this);
    }

    /**
     * @return {@link CampaignSectionsRequest} instance.
     */
    @SuppressWarnings("unused")
    public CampaignSectionsRequest campaignSections() {
        return new CampaignSectionsRequest(this);
    }

    /**
     * @return {@link ConfigRequest} instance.
     */
    @SuppressWarnings("unused")
    public ConfigRequest config() {
        return new ConfigRequest(this);
    }

    /**
     * @return {@link LicenseRequest} instance.
     */
    @SuppressWarnings("unused")
    public LicenseRequest licenses() {
        return new LicenseRequest(this);
    }

    /**
     * @return {@link ChannelRequest} instance.
     */
    @SuppressWarnings("unused")
    public ChannelRequest channels() {
        return new ChannelRequest(this);
    }

    /**
     * @return {@link LicenseChannelRequest} instance.
     */
    @SuppressWarnings("unused")
    public LicenseChannelRequest licenseChannels() {
        return new LicenseChannelRequest(this);
    }

    /**
     * @return {@link CommentRequest} instance.
     */
    @SuppressWarnings("unused")
    public CommentRequest comments() {
        return new CommentRequest(this);
    }

    /**
     * @return {@link TopicsRequest} instance.
     */
    @SuppressWarnings("unused")
    public TopicsRequest topics() {
        return new TopicsRequest(this);
    }

    /**
     * @return {@link FeaturesRequest} instance.
     */
    @SuppressWarnings("unused")
    public FeaturesRequest features() {
        return new FeaturesRequest(this);
    }

    /**
     * @return {@link FoldersRequest} instance.
     */
    public FoldersRequest folders() {
        return new FoldersRequest(this);
    }

    /**
     * @return {@link FollowersRequest} instance.
     */
    @SuppressWarnings("unused")
    public FollowersRequest followers() {
        return new FollowersRequest(this);
    }

    /**
     * @return {@link InteractionRequest} instance.
     */
    @SuppressWarnings("unused")
    public InteractionRequest interactions() {
        return new InteractionRequest(this);
    }

    /**
     * @return {@link LicenseSettingsRequest} instance.
     */
    @SuppressWarnings("unused")
    public LicenseSettingsRequest licenseSettings() {
        return new LicenseSettingsRequest(this);
    }

    /**
     * @return {@link LicenseUsersRequest} instance.
     */
    @SuppressWarnings("unused")
    public LicenseUsersRequest licenseUsers() {
        return new LicenseUsersRequest(this);
    }

    /**
     * @return {@link LinksRequest} instance.
     */
    @SuppressWarnings("unused")
    public LinksRequest links() {
        return new LinksRequest(this);
    }

    /**
     * @return {@link MediaRequest} instance.
     * @deprecated {@link #assets()} should be used instead.
     */
    @SuppressWarnings("unused")
    public MediaRequest media() {
        return new MediaRequest(this);
    }

    /**
     * @return {@link MediaReleaseRequest} instance.
     */
    @SuppressWarnings("unused")
    public MediaReleaseRequest mediaRelease() {
        return new MediaReleaseRequest(this);
    }

    /**
     * @return {@link MetadataRequest} instance.
     */
    @SuppressWarnings("unused")
    public MetadataRequest metadata() {
        return new MetadataRequest(this);
    }

    /**
     * @return {@link FacebookMonitoringRequest} instance.
     */
    @SuppressWarnings("unused")
    public FacebookMonitoringRequest facebookMonitoring() {
        return new FacebookMonitoringRequest(this);
    }

    /**
     * @return {@link TwitterMonitoringRequest} instance.
     */
    @SuppressWarnings("unused")
    public TwitterMonitoringRequest twitterMonitoring() {
        return new TwitterMonitoringRequest(this);
    }

    /**
     * @return {@link InstagramMonitoringRequest} instance.
     */
    @SuppressWarnings("unused")
    public InstagramMonitoringRequest instagramMonitoring() {
        return new InstagramMonitoringRequest(this);
    }

    /**
     * @return {@link FlaggingRequest} instance.
     */
    @SuppressWarnings("unused")
    public FlaggingRequest flags() {
        return new FlaggingRequest(this);
    }

    /**
     * @return {@link PlatformsRequest} instance.
     */
    @SuppressWarnings("unused")
    public PlatformsRequest platforms() {
        return new PlatformsRequest(this);
    }

    /**
     * @return {@link PreferenceRequest} instance.
     */
    public PreferenceRequest preference() {
        return new PreferenceRequest(this);
    }

    /**
     * @return {@link PreviewFormatRequest} instance.
     */
    @SuppressWarnings("unused")
    public PreviewFormatRequest previewFormat() {
        return new PreviewFormatRequest(this);
    }

    /**
     * @return {@link PreviewRequest} instance.
     */
    @SuppressWarnings("unused")
    public PreviewRequest preview() {
        return new PreviewRequest(this);
    }

    /**
     * @return {@link PushTokenRequest} instance.
     */
    @SuppressWarnings("unused")
    public PushTokenRequest pushToken() {
        return new PushTokenRequest(this);
    }

    /**
     * @return {@link ReleaseFormRequest} instance.
     */
    @SuppressWarnings("unused")
    public ReleaseFormRequest releaseForm() {
        return new ReleaseFormRequest(this);
    }

    /**
     * @return {@link RolesRequest} instance.
     */
    @SuppressWarnings("unused")
    public RolesRequest roles() {
        return new RolesRequest(this);
    }

    /**
     * @return {@link CannedResponsesRequest} instance.
     */
    @SuppressWarnings("unused")
    public CannedResponsesRequest cannedResponses() {
        return new CannedResponsesRequest(this);
    }

    /**
     * @return {@link SchemasRequest} instance.
     */
    @SuppressWarnings("unused")
    public SchemasRequest schemas() {
        return new SchemasRequest(this);
    }

    /**
     * @return {@link SharesRequest} instance.
     */
    @SuppressWarnings("unused")
    public SharesRequest shares() {
        return new SharesRequest(this);
    }

    /**
     * @return {@link StreamsRequest} instance.
     */
    @SuppressWarnings("unused")
    public StreamsRequest streams() {
        return new StreamsRequest(this);
    }

    /**
     * @return {@link PostRequest} instance.
     */
    @SuppressWarnings("unused")
    public PostRequest post() {
        return new PostRequest(this);
    }

    /**
     * @return {@link PostPlugRequest} instance.
     */
    @SuppressWarnings("unused")
    public PostPlugRequest postPlug() {
        return new PostPlugRequest(this);
    }

    /**
     * @return {@link PostSetRequest} instance.
     */
    @SuppressWarnings("unused")
    public PostSetRequest postSet() {
        return new PostSetRequest(this);
    }

    /**
     * @return {@link PostAttachmentRequest} instance.
     */
    @SuppressWarnings("unused")
    public PostAttachmentRequest postAttachment() {
        return new PostAttachmentRequest(this);
    }

    /**
     * @return {@link TasksRequest} instance.
     */
    @SuppressWarnings("unused")
    public TasksRequest tasks() {
        return new TasksRequest(this);
    }

    /**
     * @return {@link TenantRequest} instance.
     */
    @SuppressWarnings("unused")
    public TenantRequest tenants() {
        return new TenantRequest(this);
    }

    /**
     * @return {@link TokensRequest} instance.
     */
    @SuppressWarnings("unused")
    public TokensRequest tokens() {
        return new TokensRequest(this);
    }

    /**
     * @return {@link TranslateRequest} instance.
     */
    @SuppressWarnings("unused")
    public TranslateRequest translate() {
        return new TranslateRequest(this);
    }

    /**
     * @return {@link UploadRequest} instance.
     */
    @SuppressWarnings("unused")
    public UploadRequest uploads() {
        return new UploadRequest(this);
    }

    /**
     * @return {@link UsersRequest} instance.
     */
    @SuppressWarnings("unused")
    public UsersRequest users() {
        return new UsersRequest(this);
    }

    /**
     * @return {@link VariantsRequest} instance.
     */
    public VariantsRequest variants() {
        return new VariantsRequest(this);
    }

    /**
     * @return {@link FacebookVendorRequest} instance.
     */
    @SuppressWarnings("unused")
    public FacebookVendorRequest vendorFacebook() {
        return new FacebookVendorRequest(this);
    }

    /**
     * @return {@link InstagramVendorRequest} instance.
     */
    @SuppressWarnings("unused")
    public InstagramVendorRequest vendorInstagram() {
        return new InstagramVendorRequest(this);
    }

    /**
     * @return {@link TwitterVendorRequest} instance.
     */
    @SuppressWarnings("unused")
    public TwitterVendorRequest vendorTwitter() {
        return new TwitterVendorRequest(this);
    }
}
