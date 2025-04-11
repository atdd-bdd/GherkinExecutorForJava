package gherkinexecutor.Feature_Data_Definition;
import java.util.*;
class AllTypesInternal{
     int anInt;
     byte aByte;
     short aShort;
     long aLong;
     float aFloat;
     double aDouble;
     boolean aBool;
     String aString;
     char aChar;
     Integer anIntObject;
     Byte aByteObject;
     Short aShortObject;
     Long aLongObject;
     Float aFloatObject;
     Double aDoubleObject;
     Boolean aBoolObject;
     Character aCharObject;
     
    public static String toDataTypeString() {
        return "AllTypesInternal {"
        +"int " 
        +"byte " 
        +"short " 
        +"long " 
        +"float " 
        +"double " 
        +"boolean " 
        +"String " 
        +"char " 
        +"Integer " 
        +"Byte " 
        +"Short " 
        +"Long " 
        +"Float " 
        +"Double " 
        +"Boolean " 
        +"Character " 
            + "} "; }  
    AllTypes toAllTypes() {
        return new AllTypes(
        String.valueOf(anInt)
        ,String.valueOf(aByte)
        ,String.valueOf(aShort)
        ,String.valueOf(aLong)
        ,String.valueOf(aFloat)
        ,String.valueOf(aDouble)
        ,String.valueOf(aBool)
        ,aString
        ,String.valueOf(aChar)
        ,String.valueOf(anIntObject)
        ,String.valueOf(aByteObject)
        ,String.valueOf(aShortObject)
        ,String.valueOf(aLongObject)
        ,String.valueOf(aFloatObject)
        ,String.valueOf(aDoubleObject)
        ,String.valueOf(aBoolObject)
        ,String.valueOf(aCharObject)
        ); }
    public AllTypesInternal(
        int anInt
        ,byte aByte
        ,short aShort
        ,long aLong
        ,float aFloat
        ,double aDouble
        ,boolean aBool
        ,String aString
        ,char aChar
        ,Integer anIntObject
        ,Byte aByteObject
        ,Short aShortObject
        ,Long aLongObject
        ,Float aFloatObject
        ,Double aDoubleObject
        ,Boolean aBoolObject
        ,Character aCharObject
        )  {
        this.anInt = anInt;
        this.aByte = aByte;
        this.aShort = aShort;
        this.aLong = aLong;
        this.aFloat = aFloat;
        this.aDouble = aDouble;
        this.aBool = aBool;
        this.aString = aString;
        this.aChar = aChar;
        this.anIntObject = anIntObject;
        this.aByteObject = aByteObject;
        this.aShortObject = aShortObject;
        this.aLongObject = aLongObject;
        this.aFloatObject = aFloatObject;
        this.aDoubleObject = aDoubleObject;
        this.aBoolObject = aBoolObject;
        this.aCharObject = aCharObject;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTypesInternal _AllTypesInternal = (AllTypesInternal) o;
         return 
                ( _AllTypesInternal.anInt == (this.anInt))
                 && ( _AllTypesInternal.aByte == (this.aByte))
                 && ( _AllTypesInternal.aShort == (this.aShort))
                 && ( _AllTypesInternal.aLong == (this.aLong))
                 && ( _AllTypesInternal.aFloat == (this.aFloat))
                 && ( _AllTypesInternal.aDouble == (this.aDouble))
                 && ( _AllTypesInternal.aBool == (this.aBool))
                 && ( _AllTypesInternal.aString.equals(this.aString))
                 && ( _AllTypesInternal.aChar == (this.aChar))
                 && ( _AllTypesInternal.anIntObject.equals(this.anIntObject))
                 && ( _AllTypesInternal.aByteObject.equals(this.aByteObject))
                 && ( _AllTypesInternal.aShortObject.equals(this.aShortObject))
                 && ( _AllTypesInternal.aLongObject.equals(this.aLongObject))
                 && ( _AllTypesInternal.aFloatObject.equals(this.aFloatObject))
                 && ( _AllTypesInternal.aDoubleObject.equals(this.aDoubleObject))
                 && ( _AllTypesInternal.aBoolObject.equals(this.aBoolObject))
                 && ( _AllTypesInternal.aCharObject.equals(this.aCharObject))
             ;  }
        @Override
        public String toString() {
            return "AllTypesInternal {"
             +"anInt = " + anInt + " "
             +"aByte = " + aByte + " "
             +"aShort = " + aShort + " "
             +"aLong = " + aLong + " "
             +"aFloat = " + aFloat + " "
             +"aDouble = " + aDouble + " "
             +"aBool = " + aBool + " "
             +"aString = " + aString + " "
             +"aChar = " + aChar + " "
             +"anIntObject = " + anIntObject + " "
             +"aByteObject = " + aByteObject + " "
             +"aShortObject = " + aShortObject + " "
             +"aLongObject = " + aLongObject + " "
             +"aFloatObject = " + aFloatObject + " "
             +"aDoubleObject = " + aDoubleObject + " "
             +"aBoolObject = " + aBoolObject + " "
             +"aCharObject = " + aCharObject + " "
             + "} " + "\n"; }

    }
