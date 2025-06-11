package gherkinexecutor.Feature_Examples;
import java.util.*;
//noinspection CanBeFinal
//noinspection UnusedImports
@SuppressWarnings({"unused", "EnhancedSwitchMigration", "ClassCanBeRecord", "NewClassNamingConvention", "RedundantSuppression"})
class LabelValueInternal{
     ID iD;
     Integer value;
     
    public static String toDataTypeString() {
        return "LabelValueInternal {"
        +"ID " 
        +"Integer " 
            + "} "; }  
    LabelValue toLabelValue() {
        return new LabelValue(
        iD.toString()
        ,String.valueOf(value)
        ); }
    public LabelValueInternal(
        ID iD
        ,Integer value
        )  {
        this.iD = iD;
        this.value = value;
        }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelValueInternal _LabelValueInternal = (LabelValueInternal) o;
         return 
                ( _LabelValueInternal.iD.equals(this.iD))
                 && ( _LabelValueInternal.value.equals(this.value))
             ;  }
        @Override
        public String toString() {
            return "LabelValueInternal {"
             +"iD = " + iD + " "
             +"value = " + value + " "
             + "} " + "\n"; }

    }
