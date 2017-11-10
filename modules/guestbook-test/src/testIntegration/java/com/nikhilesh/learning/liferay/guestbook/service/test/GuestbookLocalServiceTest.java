package com.nikhilesh.learning.liferay.guestbook.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osgi.service.component.annotations.Reference;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.rule.Sync;
import com.liferay.portal.kernel.test.rule.SynchronousDestinationTestRule;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.service.test.ServiceTestUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.nikhilesh.learning.liferay.guestbook.model.Guestbook;
import com.nikhilesh.learning.liferay.guestbook.service.GuestbookLocalService;

@RunWith(Arquillian.class)
@Sync
public class GuestbookLocalServiceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(), SynchronousDestinationTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();
		_user = TestPropsValues.getUser();

		ServiceTestUtil.setUser(TestPropsValues.getUser());
	}
	
	@Test
	public void testGetGuestbooks() {
		List<Guestbook> guestbooks = _guestbookLocalService.getGuestbooks(_group.getGroupId());
		System.out.println("Testing number of guestbooks" + guestbooks.size());
	}

	@DeleteAfterTestRun
	private Group _group;

	private User _user;
	
	@Reference(unbind="-")
	public void setGuestbookLocalService(GuestbookLocalService guestbookLocalService) {
		_guestbookLocalService = guestbookLocalService;
	}
	
	private GuestbookLocalService _guestbookLocalService;
}
