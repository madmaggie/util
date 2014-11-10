package com.movies.sync;

import com.movies.entities.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;


public class FolderUtils {

  private static final Logger logger = LoggerFactory.getLogger(FolderUtils.class);
  
  public static Set<Movie> createFolderList(String sourcePath, Set<String> folderNames) {
    Set<Movie> folderList = new HashSet<>();
    for (String movie:folderNames) {
      folderList.add(new Movie(movie));
    }
    return folderList;
  }
  
  public static Set<String> generateFolderList(String sourcePath) {
    Set<String> folderList = new HashSet<>();
    try (DirectoryStream<Path> movieDir = Files.newDirectoryStream(Paths.get(sourcePath))) {
      for (Path folder: movieDir) {
       folderList.add(folder.getFileName().toString());
      }
    } catch (IOException e) {
     e.printStackTrace(); 
    }
    return folderList;
  }
  
  public static void printFolderSubset(String message, Set<Movie> folderList) {
    logger.info(message);
    for (Movie movie: folderList) {
      movie.writeMovie();
    }
  }
  
  public static Set<String> getFolderDifference(String source, String destination) {
    Set<String> sourceFolder = FolderUtils.generateFolderList(source);
    Set<String> finalResult = FolderUtils.generateFolderList(source);
    Set<String> destinationFolder = FolderUtils.generateFolderList(destination);
    sourceFolder.retainAll(destinationFolder);
    finalResult.removeAll(sourceFolder);
    return finalResult;
  }
}
