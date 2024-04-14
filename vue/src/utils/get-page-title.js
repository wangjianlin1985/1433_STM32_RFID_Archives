import defaultSettings from '@/settings'

const title = defaultSettings.title || '我的毕设'

export default function getPageTitle(pageTitle) {
  if (pageTitle) {
    return `${pageTitle} - ${title}`
  }
  return `${title}`
}
