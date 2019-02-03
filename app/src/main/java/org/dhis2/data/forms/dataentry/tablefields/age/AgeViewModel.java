package org.dhis2.data.forms.dataentry.tablefields.age;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import org.dhis2.data.forms.dataentry.tablefields.FieldViewModel;

import java.util.List;

import javax.annotation.Nonnull;

/**
 * QUADRAM. Created by frodriguez on 20/03/2018.
 */

@AutoValue
public abstract class AgeViewModel extends FieldViewModel {

    @NonNull
    public abstract Boolean mandatory();

    @Nullable
    public abstract String value();

    public static FieldViewModel create(String id, String label, Boolean mandatory, String value, String section, Boolean editable, String description, @NonNull String dataElement, @NonNull List<String> listCategoryOption, @NonNull String storeBy) {
        return new AutoValue_AgeViewModel(id, label, section, null, editable, null, null, null, description,dataElement, listCategoryOption, storeBy, mandatory, value);
    }

    @Override
    public FieldViewModel setMandatory() {
        return new AutoValue_AgeViewModel(uid(), label(), programStageSection(), allowFutureDate(), editable(), optionSet(), warning(), error(), description(), dataElement(),listCategoryOption(), storeBy(), true, value());
    }

    @NonNull
    @Override
    public FieldViewModel withError(@NonNull String error) {
        return new AutoValue_AgeViewModel(uid(), label(), programStageSection(), allowFutureDate(), editable(), optionSet(), warning(), error, description(), dataElement(),listCategoryOption(), storeBy(), mandatory(), value());
    }

    @NonNull
    @Override
    public FieldViewModel withWarning(@NonNull String warning) {
        return new AutoValue_AgeViewModel(uid(), label(), programStageSection(), allowFutureDate(), editable(), optionSet(), warning, error(), description(), dataElement(),listCategoryOption(), storeBy(), mandatory(), value());
    }

    @Nonnull
    @Override
    public FieldViewModel withValue(String data) {
        return new AutoValue_AgeViewModel(uid(), label(), programStageSection(), allowFutureDate(), editable(), optionSet(), warning(), error(), description(), dataElement(),listCategoryOption(), storeBy(), mandatory(), data);
    }
}
