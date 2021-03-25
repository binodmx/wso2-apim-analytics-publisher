/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.am.analytics.publisher.reporter.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.am.analytics.publisher.exception.MetricReportingException;
import org.wso2.am.analytics.publisher.reporter.CounterMetric;
import org.wso2.am.analytics.publisher.reporter.MetricEventBuilder;
import org.wso2.am.analytics.publisher.reporter.MetricSchema;

import java.util.Map;

/**
 * Log counter metric class. Intended for testing only.
 */
public class LogCounterMetric implements CounterMetric {
    private static final Logger log = LoggerFactory.getLogger(LogCounterMetric.class);
    private final String name;

    protected LogCounterMetric(String name) {
        this.name = name;
    }

    @Override
    public int incrementCount(MetricEventBuilder builder) throws MetricReportingException {
        Map<String, Object> properties = builder.build();
        log.info("Metric Name: " + name.replaceAll("[\r\n]", "") + " Metric Value: "
                         + properties.toString().replaceAll("[\r\n]", ""));
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public MetricSchema getSchema() {
        return null;
    }

    @Override
    public MetricEventBuilder getEventBuilder() {
        return new LogMetricEventBuilder();
    }
}
