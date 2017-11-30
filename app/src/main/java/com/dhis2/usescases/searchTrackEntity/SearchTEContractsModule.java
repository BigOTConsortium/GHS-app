package com.dhis2.usescases.searchTrackEntity;

import android.app.DatePickerDialog;
import android.location.LocationListener;
import android.support.annotation.Nullable;

import com.dhis2.usescases.general.AbstractActivityContracts;
import com.dhis2.usescases.programDetail.TrackedEntityObject;

import org.hisp.dhis.android.core.option.OptionModel;
import org.hisp.dhis.android.core.program.ProgramModel;
import org.hisp.dhis.android.core.trackedentity.TrackedEntityAttributeModel;
import org.hisp.dhis.android.core.trackedentity.TrackedEntityInstance;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ppajuelo on 02/11/2017.
 */
public class SearchTEContractsModule {

    public interface View extends AbstractActivityContracts.View {
        void setForm(List<TrackedEntityAttributeModel> trackedEntityAttributeModels, @Nullable ProgramModel program);

        void showDateDialog(DatePickerDialog.OnDateSetListener listener);

        void swapData(TrackedEntityObject body, List<TrackedEntityAttributeModel> attributeModels, List<ProgramModel> programModels);

        void setPrograms(List<ProgramModel> programModels);
    }

    public interface Presenter {

        void init(SearchTEContractsModule.View view);

        void onDateClick(@Nullable DatePickerDialog.OnDateSetListener listener);

        Observable<List<OptionModel>> getOptions(String s);

        void query(String format, boolean isAttribute);

        void setProgram(ProgramModel programSelected);

        void onBackClick();

        void onClearClick();

        void requestCoordinates(LocationListener locationListener);

        void clearFilter(String uid);

        void onEnrollClick(android.view.View view);

        void onTEIClick(String TEIuid);
    }

    public interface Interactor {
        void init(View view);

        void getTrackedEntityAttributes();

        void getProgramTrackedEntityAttributes();

        Observable<List<OptionModel>> getOptions(String optionSetId);

        void filterTrackEntities(String filter);

        void setProgram(ProgramModel programSelected);

        void addDateQuery(String filter);

        void clear();

        void clearFilter(String uid);

        void enroll();
    }

    public interface Router {

    }
}
