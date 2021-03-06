package it.mam.REST.data.impl;

import it.mam.REST.data.model.Group;
import it.mam.REST.data.model.RESTDataLayer;
import it.mam.REST.data.model.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alex
 */
public class ServiceMySQL implements Service {

    private int ID;
    private String name;
    private String description;
    private String scriptName;
    protected boolean dirty;

    protected RESTDataLayer dataLayer;

    private List<Group> groups;

    public ServiceMySQL(RESTDataLayer dataLayer) {

        ID = 0;
        name = "";
        description = "";
        scriptName = "";
        dirty = false;

        this.dataLayer = dataLayer;

        groups = null;
    }

    public ServiceMySQL(RESTDataLayer dataLayer, ResultSet rs) throws SQLException {

        this(dataLayer);
        ID = rs.getInt("ID");
        name = rs.getString("name");
        description = rs.getString("description");
        scriptName = rs.getString("script_name");
    }

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
        dirty = true;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
        dirty = true;
    }

    @Override
    public String getScriptName() {
        return scriptName;
    }

    @Override
    public void setScriptName(String scriptName) {
        this.scriptName = scriptName;
        dirty = true;
    }

    @Override
    public boolean isDirty() {
        return dirty;
    }

    @Override
    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }

    @Override
    public List<Group> getGroups() {
        if (groups == null) {
            groups = dataLayer.getGroups(this);
        }
        return groups;
    }

    @Override
    public void setGroups(List<Group> groups) {
        this.groups = groups;
        dirty = true;
    }

    @Override
    public void addGroup(Group group) {
        if (groups == null) {
            groups = dataLayer.getGroups(this);
        }
        groups.add(group);
        dirty = true;
    }

    @Override
    public void removeGroup(Group group) {
        if (groups == null) {
            groups = dataLayer.getGroups(this);
        }
        groups.remove(group);
        dirty = true;
    }

    @Override
    public void removeAllGroup() {
        groups.clear();
        dirty = true;
    }

    @Override
    public void copyFrom(Service service) {
        ID = service.getID();
        description = service.getDescription();
        name = service.getName();
        scriptName = service.getScriptName();

        groups = null;

        dirty = true;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\n"
                + "Description: " + description + "\n"
                + "Name: " + name + "\n"
                + "ScriptName: " + scriptName + "\n"
                + "Dirty: " + dirty + "\n"
                + "Groups: " + groups;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // se hanno lo stesso riferimento restituisco true
            return true;
        }
        if (obj == null || !(obj instanceof Service)) { // se non sono dello stesso "tipo" restituisco false
            return false;
        }
        // vuol dire che obj è di tipo Service quindi posso fare il cast
        Service s = (Service) obj;
        return ID == s.getID();
    }

}
