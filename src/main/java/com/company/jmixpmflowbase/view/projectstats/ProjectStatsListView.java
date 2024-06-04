package com.company.jmixpmflowbase.view.projectstats;

import com.company.jmixpmflowbase.app.ProjectStatsService;
import com.company.jmixpmflowbase.entity.ProjectStats;
import com.company.jmixpmflowbase.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.LoadContext;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Route(value = "projectStats", layout = MainView.class)
@ViewController("ProjectStats.list")
@ViewDescriptor("project-stats-list-view.xml")
@LookupComponent("projectStatsDataGrid")
@DialogMode(width = "50em")
public class ProjectStatsListView extends StandardListView<ProjectStats> {

    @Autowired
    private ProjectStatsService projectStatsService;

    @Install(to = "projectStatsDl", target = Target.DATA_LOADER)
    private List<ProjectStats> projectStatsDlLoadDelegate(final LoadContext<ProjectStats> loadContext) {
        return projectStatsService.fetchProjectStatistics();
    }

}
