/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.beam.sdk.io.common;

import javax.annotation.Nullable;
import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.Validation;

/** Pipeline options for all file based IOITs. */
public interface FileBasedIOTestPipelineOptions extends IOTestPipelineOptions {

  @Description("Destination prefix for files generated by the test")
  @Validation.Required
  String getFilenamePrefix();

  void setFilenamePrefix(String prefix);

  @Description("File compression type for writing and reading test files")
  @Default.String("UNCOMPRESSED")
  String getCompressionType();

  void setCompressionType(String compressionType);

  @Description("Number of files this test will create during the write phase.")
  @Nullable
  Integer getNumberOfShards();

  void setNumberOfShards(@Nullable Integer value);

  @Description("Option to report GCS performance metrics")
  @Default.Boolean(false)
  boolean getReportGcsPerformanceMetrics();

  void setReportGcsPerformanceMetrics(boolean performanceMetrics);

  @Validation.Required
  @Description(
      "Precomputed hashcode to assert IO test pipeline content identity after writing and reading back the dataset")
  String getExpectedHash();

  void setExpectedHash(String hash);

  @Description("Size of data saved on the target filesystem (bytes)")
  Integer getDatasetSize();

  void setDatasetSize(Integer size);
}
