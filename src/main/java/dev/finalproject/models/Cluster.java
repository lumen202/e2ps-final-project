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

    public int getCluster_ID() {
        return this.clusterIDProperty().get();
    }

    public void setCluster_ID(int cluster_ID) {
        clusterIDProperty().set(cluster_ID);
    }

    @Override
    public FXModel clone() {
        Cluster cluster = new Cluster(this.getCluster_ID(), this.clusterNameProperty().get());
        return cluster;
    }

    @Override
    public void copy(FXModel arg0) {
        Cluster cluster = (Cluster) arg0;
        this.setCluster_ID(cluster.getCluster_ID());
        this.clusterNameProperty().set(cluster.clusterNameProperty().get());
    }

}
