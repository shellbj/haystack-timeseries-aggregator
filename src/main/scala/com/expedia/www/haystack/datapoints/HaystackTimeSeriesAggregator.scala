/*
 *
 *     Copyright 2017 Expedia, Inc.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 *
 */

package com.expedia.www.haystack.datapoints

import com.codahale.metrics.JmxReporter
import com.expedia.www.haystack.datapoints.metrics.MetricsSupport
import com.expedia.www.haystack.datapoints.config.ProjectConfiguration._


object HaystackTimeSeriesAggregator extends MetricsSupport {

  private var jmxReporter: JmxReporter = _

  def main(args: Array[String]): Unit = {
    startJmxReporter()
    new StreamTopology(kafkaConfig).start()

  }

  private def startJmxReporter() = {
    jmxReporter = JmxReporter.forRegistry(metricRegistry).build()
    jmxReporter.start()
  }
}
