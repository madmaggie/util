package com.utils.collections

import java.io.{File, IOException}

import com.utils.file.JsonUtil
import org.apache.commons.io.FileUtils
import org.springframework.stereotype.Component

import collection.JavaConverters._
import collection.mutable.Buffer
import collection.JavaConversions._
import java.util.{ArrayList, HashMap}

/**
 * Created by Rox on 07.02.2015.
 */


@Component
class SomeSuff {

  type RawDataEntity = Map[String, Object]

  @throws(classOf[IOException])
  def readDataFromInstrumentAndPosition: java.util.Map[String, Object] = {

    val instrumentMap: java.util.Map[String, Object] = JsonUtil.jsonToMap("file1")
    val positionMap: java.util.Map[String, Object] = JsonUtil.jsonToMap("file2")
    var mergedMap: java.util.Map[String, Object] = new HashMap[String, Object]
    mergedMap.putAll(instrumentMap)
    mergedMap.putAll(positionMap)
    mergedMap
  }

  @throws(classOf[IOException])
  def convertToCSVFormat(mergedMap: java.util.Map[String, Object]): String = {

    val sb1: StringBuilder = new StringBuilder
    val sb2: StringBuilder = new StringBuilder      // normal output is sb1, but use sb2 to see differences
    val lineEnd: String = "\r\n"
    val fieldSeparator: String = "\t"

    // Problem: Getting all keys in a printable format
    mapAsJavaMap(mergedMap).keys.addString(sb1, fieldSeparator)

    // Example of find & replace within the StringBuilder
    var position: Int = sb1.lastIndexOf("FIRSTFILEFIRSTCOLUMN")
    sb1.replace(position, position + "FIRSTFILEFIRSTCOLUMN".length(), "firstFileFirstColumn")
    sb1.append(lineEnd)

    mapAsJavaMap(mergedMap).values().addString(sb1, fieldSeparator)
    sb1.append(lineEnd)


    // Example of a way to traverse the map, but it will look ugly if you print it to a file
    for (value <- mergedMap.values()) {
      sb2.append(fieldSeparator, value.toString)
    }

    sb1.toString
  }
}


