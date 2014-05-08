/*
 * Copyright 2014 Alexander Chauncey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.censoredsoftware.library.data;

/**
 * Meta data for an ID type.
 */
public interface IdType
{
	/**
	 * Return the ID from a string representation.
	 *
	 * @param string The string.
	 * @param <K>    Key type.
	 * @return The ID.
	 */
	<K> K fromString(String string);

	/**
	 * Get the class of this ID type.
	 *
	 * @return
	 */
	Class getCastClass();
}
