package fr.lutarony.web.definition;

import org.primefaces.context.RequestContext;

import fr.lutarony.business.definition.ITeamBO;

public class TeamEditBean {

	public ITeamBO teamBO;
	
	public void editTeam() {  
        RequestContext.getCurrentInstance().openDialog("edit-team");  
    }
}
