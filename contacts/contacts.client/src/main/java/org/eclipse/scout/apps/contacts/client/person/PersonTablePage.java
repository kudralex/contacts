package org.eclipse.scout.apps.contacts.client.person;

import org.eclipse.scout.apps.contacts.client.common.CountryLookupCall;
import org.eclipse.scout.apps.contacts.client.person.PersonTablePage.Table;
import org.eclipse.scout.apps.contacts.shared.person.IPersonTableService;
import org.eclipse.scout.apps.contacts.shared.person.PersonTableTablePageData;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractSmartColumn;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;

@Data(PersonTableTablePageData.class)
public class PersonTablePage extends AbstractPageWithTable<Table> {

    @Override
    protected boolean getConfiguredLeaf() {
        return true;
    }

    @Override
    protected void execLoadData(SearchFilter filter) {
        importPageData(BEANS.get(IPersonTableService.class).getPersonTableTableData(filter));
    }

//    @Override
//    protected void execLoadData(SearchFilter filter) {
//      importPageData(BEANS.get(IPersonService.class)
//        .getPersonTableData(filter, getOrganizationId())); (2)
//    }

    @Override
    protected String getConfiguredTitle() {
// TODO [zzzSur] verify translation
        return TEXTS.get("Persons");
    }

    public class Table extends AbstractTable {
      public CityColumn getCityColumn() {
        return getColumnSet().getColumnByClass(CityColumn.class);
      }

      public CountryColumn getCountryColumn() {
        return getColumnSet().getColumnByClass(CountryColumn.class);
      }

      public EmailColumn getEmailColumn() {
        return getColumnSet().getColumnByClass(EmailColumn.class);
      }

      public FirstNameColumn getFirstNameColumn() {
        return getColumnSet().getColumnByClass(FirstNameColumn.class);
      }

      public LastNameColumn getLastNameColumn() {
        return getColumnSet().getColumnByClass(LastNameColumn.class);
      }

      public MobileColumn getMobileColumn() {
        return getColumnSet().getColumnByClass(MobileColumn.class);
      }

      public PersonalIdColumn getPersonalIdColumn() {
        return getColumnSet().getColumnByClass(PersonalIdColumn.class);
      }

      public PhoneColumn getPhoneColumn() {
        return getColumnSet().getColumnByClass(PhoneColumn.class);
      }

      @Order(8)
      public class EmailColumn  extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Email");
        }

        @Override
        protected boolean getConfiguredVisible() {
          return false;
        }

        @Override
        protected int getConfiguredWidth() {
          return 100;
        }
      }
      @Order(7)
      public class MobileColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Mobile");
        }

        @Override
        protected boolean getConfiguredVisible() {
          return false;
        }

        @Override
        protected int getConfiguredWidth() {
          return 100;
        }
      }
      @Order(6)
      public class PhoneColumn  extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Phone");
        }

        @Override
        protected boolean getConfiguredVisible() {
          return false;
        }

        @Override
        protected int getConfiguredWidth() {
          return 100;
        }
      }
      @Order(5)
      public class CountryColumn extends AbstractSmartColumn<String> {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("Country");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }

        protected Class<? extends ILookupCall<String>> getConfiguredLookupCall() {
          return CountryLookupCall.class;
        }

      }
      @Order(4)
      public class CityColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("City");
        }

        @Override
        protected int getConfiguredWidth() {
          return 100;
        }
      }
      @Order(3)
      public class LastNameColumn extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("LastName");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }
      }
      @Order(2)
      public class FirstNameColumn  extends AbstractStringColumn {
        @Override
        protected String getConfiguredHeaderText() {
          return TEXTS.get("FirstName");
        }

        @Override
        protected int getConfiguredWidth() {
          return 120;
        }
      }
      @Order(1)
      public class PersonalIdColumn extends AbstractStringColumn {
//        @Override
//        protected String getConfiguredHeaderText() {
//          return TEXTS.get("MyNlsKey");
//        }
//
//        @Override
//        protected int getConfiguredWidth() {
//          return 100;
//        }

        @Override
        protected boolean getConfiguredDisplayable() {
          return false;
        }

        @Override
        protected boolean getConfiguredPrimaryKey() {
          return true;
        }
      }

    }
}
