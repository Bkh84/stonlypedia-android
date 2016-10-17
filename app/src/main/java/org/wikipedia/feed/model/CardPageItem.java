package org.wikipedia.feed.model;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.JsonAdapter;

import org.wikipedia.page.Namespace;
import org.wikipedia.page.NamespaceTypeAdapter;
import org.wikipedia.util.StringUtil;

public final class CardPageItem {
    @SuppressWarnings("unused,NullableProblems") @NonNull private String title;
    @SuppressWarnings("unused,NullableProblems") @NonNull private String normalizedtitle;
    @SuppressWarnings("unused") @Nullable private Thumbnail thumbnail;
    @SuppressWarnings("unused") @Nullable private String description;
    @SuppressWarnings("unused") @Nullable private String extract;
    @SuppressWarnings("unused") @NonNull @JsonAdapter(NamespaceTypeAdapter.class) private Namespace namespace = Namespace.MAIN;

    @NonNull
    public String title() {
        return title;
    }

    @NonNull
    public String normalizedTitle() {
        return normalizedtitle;
    }

    @Nullable
    public String description() {
        return description;
    }

    @Nullable
    public String extract() {
        // todo: the service should strip IPA.
        return extract == null ? null : StringUtil.sanitizeText(extract);
    }

    @NonNull
    public Namespace namespace() {
        return namespace;
    }

    @Nullable
    public Uri thumbnail() {
        return thumbnail != null ? thumbnail.source() : null;
    }
}
