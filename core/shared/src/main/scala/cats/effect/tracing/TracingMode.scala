/*
 * Copyright (c) 2017-2019 The Typelevel Cats-effect Project Developers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cats.effect.tracing

sealed abstract private[effect] class TracingMode

private[effect] object TracingMode {

  case object Disabled extends TracingMode

  case object Rabbit extends TracingMode

  case object Slug extends TracingMode

  def fromString(value: String): Option[TracingMode] =
    value.toLowerCase() match {
      case "disabled" => Some(Disabled)
      case "rabbit"   => Some(Rabbit)
      case "slug"     => Some(Slug)
      case _          => None
    }

}
