package com.jl.test

import org.slf4j.LoggerFactory

import com.twitter.scalding._

class ScaldingWordCount(args : Args) extends Job(args) {

  import ScaldingWordCount._

  TextLine( args("input") )
    .flatMap('line -> 'word) { line : String => line.split("""\s+""") }
    .groupBy('word) { _.size }
    .write( Tsv( args("output") ) )
}

object ScaldingWordCount {

  private val LOGGER = LoggerFactory.getLogger(getClass)

}
