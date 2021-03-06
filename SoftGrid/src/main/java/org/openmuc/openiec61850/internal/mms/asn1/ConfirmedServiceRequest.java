/* Copyright (C) 2016 Advanced Digital Science Centre

        * This file is part of Soft-Grid.
        * For more information visit https://www.illinois.adsc.com.sg/cybersage/
        *
        * Soft-Grid is free software: you can redistribute it and/or modify
        * it under the terms of the GNU General Public License as published by
        * the Free Software Foundation, either version 3 of the License, or
        * (at your option) any later version.
        *
        * Soft-Grid is distributed in the hope that it will be useful,
        * but WITHOUT ANY WARRANTY; without even the implied warranty of
        * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        * GNU General Public License for more details.
        *
        * You should have received a copy of the GNU General Public License
        * along with Soft-Grid.  If not, see <http://www.gnu.org/licenses/>.

        * @author Prageeth Mahendra Gunathilaka
*/
/**
 * This class file was automatically generated by jASN1 (http://www.openmuc.org)
 */

package org.openmuc.openiec61850.internal.mms.asn1;

import java.io.IOException;
import java.io.InputStream;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerIdentifier;
import org.openmuc.jasn1.ber.BerLength;

public final class ConfirmedServiceRequest {

	public byte[] code = null;
	public GetNameListRequest getNameList = null;

	public ReadRequest read = null;

	public WriteRequest write = null;

	public GetVariableAccessAttributesRequest getVariableAccessAttributes = null;

	public DefineNamedVariableListRequest defineNamedVariableList = null;

	public ObjectName getNamedVariableListAttributes = null;

	public DeleteNamedVariableListRequest deleteNamedVariableList = null;

	public ConfirmedServiceRequest() {
	}

	public ConfirmedServiceRequest(byte[] code) {
		this.code = code;
	}

	public ConfirmedServiceRequest(GetNameListRequest getNameList, ReadRequest read, WriteRequest write,
			GetVariableAccessAttributesRequest getVariableAccessAttributes,
			DefineNamedVariableListRequest defineNamedVariableList, ObjectName getNamedVariableListAttributes,
			DeleteNamedVariableListRequest deleteNamedVariableList) {
		this.getNameList = getNameList;
		this.read = read;
		this.write = write;
		this.getVariableAccessAttributes = getVariableAccessAttributes;
		this.defineNamedVariableList = defineNamedVariableList;
		this.getNamedVariableListAttributes = getNamedVariableListAttributes;
		this.deleteNamedVariableList = deleteNamedVariableList;
	}

	public int encode(BerByteArrayOutputStream berOStream, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				berOStream.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		int sublength;

		if (deleteNamedVariableList != null) {
			codeLength += deleteNamedVariableList.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 13))
					.encode(berOStream);
			return codeLength;

		}

		if (getNamedVariableListAttributes != null) {
			sublength = getNamedVariableListAttributes.encode(berOStream, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(berOStream, sublength);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 12))
					.encode(berOStream);
			return codeLength;

		}

		if (defineNamedVariableList != null) {
			codeLength += defineNamedVariableList.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 11))
					.encode(berOStream);
			return codeLength;

		}

		if (getVariableAccessAttributes != null) {
			sublength = getVariableAccessAttributes.encode(berOStream, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(berOStream, sublength);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6))
					.encode(berOStream);
			return codeLength;

		}

		if (write != null) {
			codeLength += write.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5))
					.encode(berOStream);
			return codeLength;

		}

		if (read != null) {
			codeLength += read.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4))
					.encode(berOStream);
			return codeLength;

		}

		if (getNameList != null) {
			codeLength += getNameList.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1))
					.encode(berOStream);
			return codeLength;

		}

		throw new IOException("Error encoding BerChoice: No item in choice was selected.");
	}

	public int decode(InputStream iStream, BerIdentifier berIdentifier) throws IOException {
		int codeLength = 0;
		BerIdentifier passedIdentifier = berIdentifier;
		if (berIdentifier == null) {
			berIdentifier = new BerIdentifier();
			codeLength += berIdentifier.decode(iStream);
		}
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			getNameList = new GetNameListRequest();
			codeLength += getNameList.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
			read = new ReadRequest();
			codeLength += read.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			write = new WriteRequest();
			codeLength += write.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
			codeLength += new BerLength().decode(iStream);
			getVariableAccessAttributes = new GetVariableAccessAttributesRequest();
			codeLength += getVariableAccessAttributes.decode(iStream, null);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 11)) {
			defineNamedVariableList = new DefineNamedVariableListRequest();
			codeLength += defineNamedVariableList.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 12)) {
			codeLength += new BerLength().decode(iStream);
			getNamedVariableListAttributes = new ObjectName();
			codeLength += getNamedVariableListAttributes.decode(iStream, null);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 13)) {
			deleteNamedVariableList = new DeleteNamedVariableListRequest();
			codeLength += deleteNamedVariableList.decode(iStream, false);
			return codeLength;
		}

		if (passedIdentifier != null) {
			return 0;
		}
		throw new IOException("Error decoding BerChoice: Identifier matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream berOStream = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(berOStream, false);
		code = berOStream.getArray();
	}
}
