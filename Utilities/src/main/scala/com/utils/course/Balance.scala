package com.utils.course

import org.springframework.stereotype.Component

/**
 * Created by Rox on 18.12.2014.
 */
@Component
class Balance {

  def countApperances (input : List[Char]) : Boolean = { def checkChar(inputList: List[Char], count : Integer, charToSearch : Character): Integer = { var changeCount = count

    if (inputList.isEmpty == true)  return changeCount

    if (inputList.head == charToSearch)
      changeCount = changeCount + 1
    checkChar(inputList.tail, changeCount, charToSearch)
  }

    if ( checkChar(input, 0, '(') == checkChar(input, 0, ')')) return true
    false
  }

  def checkClosingBracket(input: List[Char]): List[Char] = {

    if (input.isEmpty == true) return input

    if (input.head == ')') {
      closedBracket = closedBracket + 1
      return input
    }

    if (input.head == '(')
      balance(input)

    if (input.head == ')')
      return input

    checkClosingBracket(input.tail)
  }

  var openBrackets : Integer = 0
  var closedBracket : Integer = 0

  def balance (input : List[Char]) : Boolean = {
    var workList : List[Char] = input

     if (input.isEmpty == true) {
      if (openBrackets == closedBracket) return true
      return false
    }

    if (input.head == '(') {
      openBrackets = openBrackets + 1
      workList = checkClosingBracket(input.tail)
    }

    if (input.head == ')')
      return false

    balance(workList.tail)
  }

  def callBalance (list : String) = { balance(list.toList) } }
