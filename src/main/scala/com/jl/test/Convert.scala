package com.jl.test

import org.slf4j.LoggerFactory

import com.twitter.scalding._
import com.jl.test.SrcFromArg._

class Convert(args : Args) extends Job(args) {

  import ScaldingWordCount._

  getSource("input",args).read
    .project('*)
    .write( getSource("output",args))
}

object Convert {

  private val LOGGER = LoggerFactory.getLogger(getClass)

}
