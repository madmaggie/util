package com.movies.sync;


import com.movies.entities.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;


/**
 * Created by Rox on 08.09.2014.
 */
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SyncFolders {

    @Value("#{props.masterFolder}")
    private String pathMaster;
    private Set<Movie> moveToMaster;

    @Value("#{props.slaveFolder}")
    private String pathSlave;
    private Set<Movie> moveToSlave;

    public void sync() {
        moveToMaster = FolderUtils.createFolderList(pathMaster, initMoveToMaster());
        FolderUtils.printFolderSubset("Move to Master Folder: ", moveToMaster);
        moveToSlave = FolderUtils.createFolderList(pathSlave, initMoveToSlave());
        FolderUtils.printFolderSubset("Move to Slave Folder: ", moveToSlave);
    }

    private Set<String> initMoveToMaster() {
        return FolderUtils.getFolderDifference(pathSlave, pathMaster);
    }

    private Set<String> initMoveToSlave() {
        return FolderUtils.getFolderDifference(pathMaster, pathSlave);
    }

    public Set<Movie> getMoveToMaster() {
        return moveToMaster;
    }

    public Set<Movie> getMoveToSlave() {
        return moveToSlave;
    }

    public void setPathMaster(String pathMaster) {
        this.pathMaster = pathMaster;
    }

    public void setPathSlave(String pathSlave) {
        this.pathSlave = pathSlave;
    }
}



