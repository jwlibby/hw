package com.jl.test

import com.twitter.scalding.Args
import com.twitter.scalding.Csv
import com.twitter.scalding.Tsv
import com.twitter.scalding.Source
import com.twitter.scalding.avro.PackedAvroSource

class SourceFromArg {

}

object SrcFromArg {
  def getSource(key: String, args: Args) : Source = args.getOrElse(key,"").split("%") match {
    case Array("csv",path: String) => Csv(path)
    case Array("tsv",path: String) => Tsv(path)
    case Array("avro",path: String) => PackedAvroSource[String](path)
    case _ => null
  }
}


