package com.utils.spark

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.stereotype.Component

import scala.annotation.meta.field


/**
 * Created by Rox on 07.12.2014.
 */
@Component
class SparkSimpleOperations @Autowired() (@Value("${fileFolder}") @field var myTextFile: String) {

  //(@BeanProperty var myTextFile: String) {

  def initContext(): SparkContext = {
    val conf = new SparkConf().setMaster("local").setAppName("My App")
    new SparkContext(conf)
  }

  def scalaDemoReturnMap(): Array[(Int, Long)] = {
    val sc = initContext()
    val logData = sc.textFile(myTextFile, 2).cache()
    val numAs = logData.filter(line => line.contains("0")).count()
    val numBs = logData.filter(line => line.contains("1")).count()

    sc.parallelize(List[Long](numAs, numBs)).collect().map(line => (1, line))
  }

  def scalaDemoReturnRDD() : RDD[Long] = {
    val sc = initContext()
    val logData = sc.textFile(myTextFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()

    sc.parallelize(List(numAs, numBs))
  }

  /*
  def scalaDemoReturnTrait() : Returnable = {
    val testReturn : Returnable = new CustomReturnType testReturn
  } */
}
