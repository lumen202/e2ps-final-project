package dev.finalproject.models;

import dev.sol.core.application.FXModel;
import dev.sol.core.properties.beans.FXIntegerProperty;
import dev.sol.core.properties.beans.FXStringProperty;

public class Cluster extends FXModel {

    private FXIntegerProperty cluster_ID;
    private FXStringProperty cluster_name;

    public Cluster(int cluster_ID, String cluster_name) {
        this.cluster_ID = new FXIntegerProperty(cluster_ID);
        this.cluster_name = new FXStringProperty(cluster_name);
    }

    public FXIntegerProperty clusterIDProperty() {
        return this.cluster_ID;
    }

    public FXStringProperty clusterNameProperty() {
        return this.cluster_name;
    }

    public int getClusterID() {
        return this.clusterIDProperty().get();
    }

    public void setClusterID(int cluster_ID) {
        clusterIDProperty().set(cluster_ID);
    }


    public void setClusterName(String clusterName) {
        clusterNameProperty().set(clusterName);
    }

    public String getClusterName() {
        return clusterNameProperty().get();
    }

    
    @Override
    public FXModel clone() {
        Cluster cluster = new Cluster(this.getClusterID(), this.clusterNameProperty().get());
        return cluster;
    }

    @Override
    public void copy(FXModel arg0) {
        Cluster cluster = (Cluster) arg0;
        this.setClusterID(cluster.getClusterID());
        this.clusterNameProperty().set(cluster.clusterNameProperty().get());
    }

}
